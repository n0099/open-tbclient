package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes15.dex */
public final class e {
    private static SharedPreferences eiq() {
        return com.baidu.ubs.analytics.d.ehZ().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        eiq().edit().putBoolean(str, true).apply();
    }

    public static boolean XF(String str) {
        return eiq().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return eiq().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        eiq().edit().putLong(str, j).apply();
    }

    public static long XG(String str) {
        return eiq().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        eiq().edit().putString(str, str2).apply();
    }
}
