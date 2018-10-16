package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences bQD() {
        return com.baidu.ubs.analytics.d.bQf().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void xU(String str) {
        bQD().edit().putBoolean(str, true).apply();
    }

    public static boolean xV(String str) {
        return bQD().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bQD().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bQD().edit().putLong(str, j).apply();
    }

    public static long xW(String str) {
        return bQD().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bQD().edit().putString(str, str2).apply();
    }
}
