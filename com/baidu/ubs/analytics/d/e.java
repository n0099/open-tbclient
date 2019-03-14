package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences csN() {
        return com.baidu.ubs.analytics.d.csq().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void EY(String str) {
        csN().edit().putBoolean(str, true).apply();
    }

    public static boolean EZ(String str) {
        return csN().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return csN().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        csN().edit().putLong(str, j).apply();
    }

    public static long Fa(String str) {
        return csN().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        csN().edit().putString(str, str2).apply();
    }
}
