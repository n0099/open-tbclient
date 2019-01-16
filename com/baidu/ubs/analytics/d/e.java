package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences bTC() {
        return com.baidu.ubs.analytics.d.bTh().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void yV(String str) {
        bTC().edit().putBoolean(str, true).apply();
    }

    public static boolean yW(String str) {
        return bTC().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bTC().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bTC().edit().putLong(str, j).apply();
    }

    public static long yX(String str) {
        return bTC().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bTC().edit().putString(str, str2).apply();
    }
}
