package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class f {
    private static long hVE;
    private static long hVF;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hVD = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hVD = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long Z() {
        return hVD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long aa() {
        return hVE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hVE = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bPM() {
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
        hVF = j;
    }

    public static long bPN() {
        return hVF;
    }
}
