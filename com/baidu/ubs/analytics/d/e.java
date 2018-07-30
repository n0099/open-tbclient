package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences bJs() {
        return com.baidu.ubs.analytics.d.bIU().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void wf(String str) {
        bJs().edit().putBoolean(str, true).apply();
    }

    public static boolean wg(String str) {
        return bJs().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bJs().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bJs().edit().putLong(str, j).apply();
    }

    public static long wh(String str) {
        return bJs().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bJs().edit().putString(str, str2).apply();
    }
}
