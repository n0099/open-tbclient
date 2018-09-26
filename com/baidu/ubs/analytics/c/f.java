package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class f {
    private static long UD;
    private static long hLb;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hLa = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hLa = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bLY() {
        return hLa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bLZ() {
        return hLb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hLb = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bMa() {
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
        UD = j;
    }

    public static long bMb() {
        return UD;
    }
}
