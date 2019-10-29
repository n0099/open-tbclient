package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long jYk;
    private static long jYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cBo() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cBp() {
        return jYk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        jYk = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cBq() {
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
        jYl = j;
    }

    public static long cBr() {
        return jYl;
    }
}
