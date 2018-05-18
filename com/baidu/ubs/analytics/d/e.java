package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class e {
    private static SharedPreferences bFj() {
        return com.baidu.ubs.analytics.d.bEL().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void vo(String str) {
        bFj().edit().putBoolean(str, true).apply();
    }

    public static boolean vp(String str) {
        return bFj().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bFj().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bFj().edit().putLong(str, j).apply();
    }

    public static long vq(String str) {
        return bFj().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bFj().edit().putString(str, str2).apply();
    }
}
