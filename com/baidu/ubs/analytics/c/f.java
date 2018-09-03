package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class f {
    private static long RY;
    private static long hCF;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hCE = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hCE = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJh() {
        return hCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJi() {
        return hCF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hCF = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bJj() {
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
        RY = j;
    }

    public static long bJk() {
        return RY;
    }
}
