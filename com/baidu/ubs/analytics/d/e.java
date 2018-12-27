package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences bSU() {
        return com.baidu.ubs.analytics.d.bSz().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void yF(String str) {
        bSU().edit().putBoolean(str, true).apply();
    }

    public static boolean yG(String str) {
        return bSU().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bSU().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bSU().edit().putLong(str, j).apply();
    }

    public static long yH(String str) {
        return bSU().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bSU().edit().putString(str, str2).apply();
    }
}
