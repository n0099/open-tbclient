package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class f {
    private static long RY;
    private static long hCD;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hCC = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hCC = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJd() {
        return hCC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bJe() {
        return hCD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hCD = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bJf() {
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

    public static long bJg() {
        return RY;
    }
}
