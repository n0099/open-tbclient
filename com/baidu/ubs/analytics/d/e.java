package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes15.dex */
public final class e {
    private static SharedPreferences eiy() {
        return com.baidu.ubs.analytics.d.eih().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        eiy().edit().putBoolean(str, true).apply();
    }

    public static boolean XR(String str) {
        return eiy().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return eiy().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        eiy().edit().putLong(str, j).apply();
    }

    public static long XS(String str) {
        return eiy().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        eiy().edit().putString(str, str2).apply();
    }
}
