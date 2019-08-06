package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cEf() {
        return com.baidu.ubs.analytics.d.cDF().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Hp(String str) {
        cEf().edit().putBoolean(str, true).apply();
    }

    public static boolean Hq(String str) {
        return cEf().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cEf().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cEf().edit().putLong(str, j).apply();
    }

    public static long Hr(String str) {
        return cEf().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cEf().edit().putString(str, str2).apply();
    }
}
