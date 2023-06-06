import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Билет №13
//        Необходимо реализовать следующий метод:
//
//        На вход получаем список названий книг.
//        Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
//        Все книги должны быть отсортированы по алфавиту с первой до последней полки.
//        Количество полок константное — 5 штук.
//        Вернуть книги, распределенные по полкам.


        List<String> books = new ArrayList<>();
        books.add("Повесть о настоящем человеке");
        books.add("Мастер и Маргарита");
        books.add("Аэропорт");
        books.add("Сказки");
        books.add("Война и мир");
        books.add("Собака Баскервилей");
        books.add("Игра престолов");
        books.add("Том Сойер");
        books.add("Маленький принц");
        books.add("Цитадель");
        books.add("Собачье сердце");
        books.add("Герой нашего времениь");

        List<ArrayList<String>> shelves = putBooksOnShelves(books);
        shelves.forEach(System.out::println);
    }
    public static List<ArrayList<String>> putBooksOnShelves(List<String> books){
        books = books.stream().sorted().collect(Collectors.toList());

        List<ArrayList<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }
        int booksOnShelves = books.size() / shelves.size();
        int remains = books.size() % shelves.size();
        int count = 0;

        for (ArrayList<String> shelf : shelves) {
            for (int i = 0; i < booksOnShelves; i++) {
                shelf.add(books.get(count++));
            }
            if (remains > 0){
                shelf.add(books.get(count++));
                remains--;
            }
        }
        return shelves;
    }
}