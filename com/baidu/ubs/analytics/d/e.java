package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences ejR() {
        return com.baidu.ubs.analytics.d.ejy().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        ejR().edit().putBoolean(str, true).apply();
    }

    public static boolean XO(String str) {
        return ejR().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return ejR().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        ejR().edit().putLong(str, j).apply();
    }

    public static long XP(String str) {
        return ejR().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        ejR().edit().putString(str, str2).apply();
    }
}
