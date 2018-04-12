package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class e {
    private static SharedPreferences bFl() {
        return com.baidu.ubs.analytics.d.bEN().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void vl(String str) {
        bFl().edit().putBoolean(str, true).apply();
    }

    public static boolean vm(String str) {
        return bFl().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bFl().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bFl().edit().putLong(str, j).apply();
    }

    public static long vn(String str) {
        return bFl().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bFl().edit().putString(str, str2).apply();
    }
}
