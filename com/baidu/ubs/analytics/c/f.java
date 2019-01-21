package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class f {
    private static long ihj;
    private static long ihk;
    private static boolean ak = true;
    private static boolean al = false;
    private static long ihi = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        ihi = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long Z() {
        return ihi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long aa() {
        return ihj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        ihj = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bTq() {
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
        ihk = j;
    }

    public static long bTr() {
        return ihk;
    }
}
