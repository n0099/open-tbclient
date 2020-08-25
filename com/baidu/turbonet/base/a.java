package com.baidu.turbonet.base;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a {
    private a() {
    }

    private static String j(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return String.format(Locale.US, str, objArr);
        }
        return str;
    }

    public static String Te(String str) {
        if (!str.startsWith("cr_")) {
            int i = 0;
            if (str.startsWith("cr.")) {
                i = "cr.".length();
            }
            return "cr_" + str.substring(i, str.length());
        }
        return str;
    }

    private static String k(String str, Object... objArr) {
        return "[" + dJO() + "] " + j(str, objArr);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String k = k(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.d(Te(str), k, L);
        } else {
            Log.d(Te(str), k);
        }
    }

    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    public static void f(String str, String str2, Object... objArr) {
        String j = j(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.i(Te(str), j, L);
        } else {
            Log.i(Te(str), j);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        String j = j(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.e(Te(str), j, L);
        } else {
            Log.e(Te(str), j);
        }
    }

    private static Throwable L(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    private static String dJO() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = a.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClassName().equals(name)) {
                i++;
            } else {
                i += 4;
                break;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }
}
