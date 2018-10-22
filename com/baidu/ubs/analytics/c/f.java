package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class f {
    private static long hTU;
    private static long hTV;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hTT = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hTT = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bQo() {
        return hTT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bQp() {
        return hTU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hTU = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bQq() {
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
        hTV = j;
    }

    public static long bQr() {
        return hTV;
    }
}
