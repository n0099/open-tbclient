package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences bPY() {
        return com.baidu.ubs.analytics.d.bPD().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void xZ(String str) {
        bPY().edit().putBoolean(str, true).apply();
    }

    public static boolean ya(String str) {
        return bPY().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bPY().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bPY().edit().putLong(str, j).apply();
    }

    public static long yb(String str) {
        return bPY().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bPY().edit().putString(str, str2).apply();
    }
}
