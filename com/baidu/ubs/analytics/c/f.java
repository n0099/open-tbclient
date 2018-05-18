package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class f {
    private static long hlW;
    private static long hlX;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hlV = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hlV = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEU() {
        return hlV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEV() {
        return hlW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hlW = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bEW() {
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
        hlX = j;
    }

    public static long bEX() {
        return hlX;
    }
}
