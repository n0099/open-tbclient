package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class f {
    private static long hkS;
    private static long hkT;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hkR = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hkR = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEW() {
        return hkR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEX() {
        return hkS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hkS = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bEY() {
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
        hkT = j;
    }

    public static long bEZ() {
        return hkT;
    }
}
