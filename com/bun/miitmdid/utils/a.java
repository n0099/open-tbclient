package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes19.dex */
public class a {
    private static a mPd;
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
        dBo().b = z ? 1 : 0;
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
        return dBo().b == 1;
    }

    public static a dBo() {
        if (mPd == null) {
            synchronized (a.class) {
                if (mPd == null) {
                    mPd = new a();
                }
            }
        }
        return mPd;
    }
}
