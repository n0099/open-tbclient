package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes5.dex */
public class a {
    private static a oJY;
    private int b = -1;

    private a() {
    }

    public static void a(String str, String str2) {
        if (b()) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (b()) {
            Log.d(str, str2, th);
        }
    }

    public static void a(boolean z) {
        eiF().b = z ? 1 : 0;
    }

    public static void b(String str, String str2) {
        if (b()) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (b()) {
            Log.e(str, str2, th);
        }
    }

    public static boolean b() {
        return eiF().b == 1;
    }

    public static a eiF() {
        if (oJY == null) {
            synchronized (a.class) {
                if (oJY == null) {
                    oJY = new a();
                }
            }
        }
        return oJY;
    }
}
