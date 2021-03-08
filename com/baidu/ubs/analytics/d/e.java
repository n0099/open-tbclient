package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes14.dex */
public final class e {
    private static SharedPreferences eiI() {
        return com.baidu.ubs.analytics.d.eip().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        eiI().edit().putBoolean(str, true).apply();
    }

    public static boolean XY(String str) {
        return eiI().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return eiI().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        eiI().edit().putLong(str, j).apply();
    }

    public static long XZ(String str) {
        return eiI().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        eiI().edit().putString(str, str2).apply();
    }
}
