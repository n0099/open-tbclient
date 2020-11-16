package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes17.dex */
public final class e {
    private static SharedPreferences edY() {
        return com.baidu.ubs.analytics.d.edz().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        edY().edit().putBoolean(str, true).apply();
    }

    public static boolean WK(String str) {
        return edY().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return edY().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        edY().edit().putLong(str, j).apply();
    }

    public static long WL(String str) {
        return edY().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        edY().edit().putString(str, str2).apply();
    }
}
