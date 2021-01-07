package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences ejS() {
        return com.baidu.ubs.analytics.d.ejz().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        ejS().edit().putBoolean(str, true).apply();
    }

    public static boolean XN(String str) {
        return ejS().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return ejS().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        ejS().edit().putLong(str, j).apply();
    }

    public static long XO(String str) {
        return ejS().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        ejS().edit().putString(str, str2).apply();
    }
}
