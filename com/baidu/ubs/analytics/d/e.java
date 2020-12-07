package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes17.dex */
public final class e {
    private static SharedPreferences ejL() {
        return com.baidu.ubs.analytics.d.ejn().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        ejL().edit().putBoolean(str, true).apply();
    }

    public static boolean Yf(String str) {
        return ejL().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return ejL().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        ejL().edit().putLong(str, j).apply();
    }

    public static long Yg(String str) {
        return ejL().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        ejL().edit().putString(str, str2).apply();
    }
}
