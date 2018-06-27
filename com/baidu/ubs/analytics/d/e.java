package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences bKO() {
        return com.baidu.ubs.analytics.d.bKq().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void we(String str) {
        bKO().edit().putBoolean(str, true).apply();
    }

    public static boolean wf(String str) {
        return bKO().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bKO().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bKO().edit().putLong(str, j).apply();
    }

    public static long wg(String str) {
        return bKO().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bKO().edit().putString(str, str2).apply();
    }
}
