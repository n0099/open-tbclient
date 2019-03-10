package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long jxg;
    private static long jxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long csw() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long csx() {
        return jxg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        jxg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean csy() {
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
        jxh = j;
    }

    public static long csz() {
        return jxh;
    }
}
