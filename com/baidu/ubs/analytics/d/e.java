package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences cYp() {
        return com.baidu.ubs.analytics.d.cXN().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Lt(String str) {
        cYp().edit().putBoolean(str, true).apply();
    }

    public static boolean Lu(String str) {
        return cYp().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cYp().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cYp().edit().putLong(str, j).apply();
    }

    public static long Lv(String str) {
        return cYp().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cYp().edit().putString(str, str2).apply();
    }
}
