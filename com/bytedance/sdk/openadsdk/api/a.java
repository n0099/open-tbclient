package com.bytedance.sdk.openadsdk.api;

import android.util.Log;
/* loaded from: classes7.dex */
public class a {
    public static boolean a = false;
    public static int b = 4;

    public static void a(int i) {
        b = i;
    }

    public static void b(String str, String str2) {
        if (a && str2 != null && b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a && str2 != null && b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a && str2 != null && b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (a && str2 != null && b <= 6) {
            Log.e(str, str2);
        }
    }

    public static void a() {
        a = true;
        a(3);
    }

    public static void a(String str, String str2) {
        if (a && str2 != null && b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void a(String str) {
        if (a) {
            d("TTLogger", str);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }
}
