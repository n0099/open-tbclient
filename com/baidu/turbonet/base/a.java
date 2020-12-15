package com.baidu.turbonet.base;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes14.dex */
public class a {
    private a() {
    }

    private static String g(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return String.format(Locale.US, str, objArr);
        }
        return str;
    }

    public static String Xi(String str) {
        if (!str.startsWith("cr_")) {
            int i = 0;
            if (str.startsWith("cr.")) {
                i = "cr.".length();
            }
            return "cr_" + str.substring(i, str.length());
        }
        return str;
    }

    private static String h(String str, Object... objArr) {
        return "[" + egM() + "] " + g(str, objArr);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String h = h(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.d(Xi(str), h, L);
        } else {
            Log.d(Xi(str), h);
        }
    }

    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    public static void f(String str, String str2, Object... objArr) {
        String g = g(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.i(Xi(str), g, L);
        } else {
            Log.i(Xi(str), g);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        String g = g(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.e(Xi(str), g, L);
        } else {
            Log.e(Xi(str), g);
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

    private static String egM() {
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
