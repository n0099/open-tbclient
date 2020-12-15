package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes17.dex */
public final class e {
    private static SharedPreferences ejM() {
        return com.baidu.ubs.analytics.d.ejo().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        ejM().edit().putBoolean(str, true).apply();
    }

    public static boolean Yf(String str) {
        return ejM().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return ejM().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        ejM().edit().putLong(str, j).apply();
    }

    public static long Yg(String str) {
        return ejM().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        ejM().edit().putString(str, str2).apply();
    }
}
