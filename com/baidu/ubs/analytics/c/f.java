package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class f {
    private static long igb;
    private static long igc;
    private static boolean ak = true;
    private static boolean al = false;
    private static long iga = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        iga = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long Z() {
        return iga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long aa() {
        return igb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        igb = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bSI() {
        return ak;
    }

    public static boolean g() {
        return ap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z) {
        ap = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(long j) {
        igc = j;
    }

    public static long bSJ() {
        return igc;
    }
}
