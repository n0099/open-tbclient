package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences dAS() {
        return com.baidu.ubs.analytics.d.dAu().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dAS().edit().putBoolean(str, true).apply();
    }

    public static boolean QS(String str) {
        return dAS().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dAS().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dAS().edit().putLong(str, j).apply();
    }

    public static long QT(String str) {
        return dAS().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dAS().edit().putString(str, str2).apply();
    }
}
