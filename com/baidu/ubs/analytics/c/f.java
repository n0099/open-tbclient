package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class f {
    private static long icO;
    private static long icP;
    private static boolean ak = true;
    private static boolean al = false;
    private static long icN = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        icN = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long Z() {
        return icN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long aa() {
        return icO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        icO = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bRR() {
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
        icP = j;
    }

    public static long bRS() {
        return icP;
    }
}
