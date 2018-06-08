package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class f {
    private static long RZ;
    private static long hxR;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hxQ = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hxQ = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJY() {
        return hxQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJZ() {
        return hxR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hxR = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bKa() {
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
        RZ = j;
    }

    public static long bKb() {
        return RZ;
    }
}
