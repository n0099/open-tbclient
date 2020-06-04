package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes6.dex */
public class a {
    private static a mkY;
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
        dtu().b = z ? 1 : 0;
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
        return dtu().b == 1;
    }

    public static a dtu() {
        if (mkY == null) {
            synchronized (a.class) {
                if (mkY == null) {
                    mkY = new a();
                }
            }
        }
        return mkY;
    }
}
