package com.baidu.turbonet.base;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes.dex */
public class a {
    private a() {
    }

    private static String j(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return String.format(Locale.US, str, objArr);
        }
        return str;
    }

    public static String MQ(String str) {
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
        return "[" + diB() + "] " + j(str, objArr);
    }

    private static void f(String str, String str2, Object... objArr) {
        String k = k(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.d(MQ(str), k, L);
        } else {
            Log.d(MQ(str), k);
        }
    }

    public static void d(String str, String str2) {
        f(str, str2, new Object[0]);
    }

    public static void g(String str, String str2, Object... objArr) {
        String j = j(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.i(MQ(str), j, L);
        } else {
            Log.i(MQ(str), j);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        String j = j(str2, objArr);
        Throwable L = L(objArr);
        if (L != null) {
            Log.e(MQ(str), j, L);
        } else {
            Log.e(MQ(str), j);
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

    private static String diB() {
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
