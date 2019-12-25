package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class e {
    private static SharedPreferences cVw() {
        return com.baidu.ubs.analytics.d.cUT().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void KW(String str) {
        cVw().edit().putBoolean(str, true).apply();
    }

    public static boolean KX(String str) {
        return cVw().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cVw().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cVw().edit().putLong(str, j).apply();
    }

    public static long KY(String str) {
        return cVw().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cVw().edit().putString(str, str2).apply();
    }
}
