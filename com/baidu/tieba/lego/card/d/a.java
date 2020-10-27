package com.baidu.tieba.lego.card.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static <T> void a(List<T> list, T t) {
        if (!isNull(list)) {
            try {
                list.add(t);
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
            }
        }
    }

    public static <T> void a(List<T> list, T t, int i) {
        if (!isNull(list) && n(list, i)) {
            try {
                list.add(i, t);
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
            }
        }
    }

    public static <T> T l(List<T> list, int i) {
        if (!isEmpty(list) && n(list, i)) {
            try {
                return list.get(i);
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
                return null;
            }
        }
        return null;
    }

    public static <T> void b(List<T> list, T t) {
        if (!isEmpty(list)) {
            try {
                list.remove(t);
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
            }
        }
    }

    public static void m(List list, int i) {
        if (!isEmpty(list) && n(list, i)) {
            try {
                list.remove(i);
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
            }
        }
    }

    public static int eu(List list) {
        if (isNull(list) || list.isEmpty()) {
            return 0;
        }
        try {
            return list.size();
        } catch (Exception e) {
            BdLog.e(e);
            x(e);
            return 0;
        }
    }

    public static void clear(List list) {
        if (!isEmpty(list)) {
            try {
                list.clear();
            } catch (Exception e) {
                BdLog.e(e);
                x(e);
            }
        }
    }

    public static boolean isEmpty(List list) {
        if (isNull(list) || list.isEmpty()) {
            BdLog.e("list is empty");
            return true;
        }
        return false;
    }

    private static boolean isNull(Object obj) {
        return obj == null;
    }

    private static boolean n(List list, int i) {
        if (isNull(list)) {
            return false;
        }
        if (i < 0 || i >= list.size()) {
            BdLog.e("list index out of bounds");
            x(new IndexOutOfBoundsException());
            return false;
        }
        return true;
    }

    private static void x(Exception exc) {
        if (!BdBaseApplication.getInst().isDebugMode() || !(exc instanceof RuntimeException)) {
            return;
        }
        throw ((RuntimeException) exc);
    }
}
