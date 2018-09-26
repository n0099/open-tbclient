package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences bMn() {
        return com.baidu.ubs.analytics.d.bLP().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void wU(String str) {
        bMn().edit().putBoolean(str, true).apply();
    }

    public static boolean wV(String str) {
        return bMn().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bMn().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bMn().edit().putLong(str, j).apply();
    }

    public static long wW(String str) {
        return bMn().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bMn().edit().putString(str, str2).apply();
    }
}
