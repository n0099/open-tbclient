package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dlv() {
        return com.baidu.ubs.analytics.d.dkT().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dlv().edit().putBoolean(str, true).apply();
    }

    public static boolean NG(String str) {
        return dlv().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dlv().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dlv().edit().putLong(str, j).apply();
    }

    public static long NH(String str) {
        return dlv().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dlv().edit().putString(str, str2).apply();
    }
}
