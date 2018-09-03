package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences bJw() {
        return com.baidu.ubs.analytics.d.bIY().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void wj(String str) {
        bJw().edit().putBoolean(str, true).apply();
    }

    public static boolean wk(String str) {
        return bJw().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bJw().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bJw().edit().putLong(str, j).apply();
    }

    public static long wl(String str) {
        return bJw().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bJw().edit().putString(str, str2).apply();
    }
}
