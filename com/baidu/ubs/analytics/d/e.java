package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences csK() {
        return com.baidu.ubs.analytics.d.csn().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Fa(String str) {
        csK().edit().putBoolean(str, true).apply();
    }

    public static boolean Fb(String str) {
        return csK().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return csK().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        csK().edit().putLong(str, j).apply();
    }

    public static long Fc(String str) {
        return csK().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        csK().edit().putString(str, str2).apply();
    }
}
