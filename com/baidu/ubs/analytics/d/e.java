package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class e {
    private static SharedPreferences dMH() {
        return com.baidu.ubs.analytics.d.dMi().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dMH().edit().putBoolean(str, true).apply();
    }

    public static boolean TS(String str) {
        return dMH().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dMH().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dMH().edit().putLong(str, j).apply();
    }

    public static long TT(String str) {
        return dMH().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dMH().edit().putString(str, str2).apply();
    }
}
