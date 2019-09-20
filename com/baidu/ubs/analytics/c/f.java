package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long kal;
    private static long kam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cED() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cEE() {
        return kal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        kal = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cEF() {
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
        kam = j;
    }

    public static long cEG() {
        return kam;
    }
}
