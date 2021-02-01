package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes15.dex */
public class a {
    private static a pmg;

    /* renamed from: b  reason: collision with root package name */
    private int f5766b = -1;

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
        enj().f5766b = z ? 1 : 0;
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
        return enj().f5766b == 1;
    }

    public static a enj() {
        if (pmg == null) {
            synchronized (a.class) {
                if (pmg == null) {
                    pmg = new a();
                }
            }
        }
        return pmg;
    }
}
