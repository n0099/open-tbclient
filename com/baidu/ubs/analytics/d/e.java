package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dlw() {
        return com.baidu.ubs.analytics.d.dkU().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dlw().edit().putBoolean(str, true).apply();
    }

    public static boolean NG(String str) {
        return dlw().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dlw().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dlw().edit().putLong(str, j).apply();
    }

    public static long NH(String str) {
        return dlw().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dlw().edit().putString(str, str2).apply();
    }
}
