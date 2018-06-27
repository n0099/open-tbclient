package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class f {
    private static long Sb;
    private static long hBY;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hBX = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hBX = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bKz() {
        return hBX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bKA() {
        return hBY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hBY = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bKB() {
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
        Sb = j;
    }

    public static long bKC() {
        return Sb;
    }
}
