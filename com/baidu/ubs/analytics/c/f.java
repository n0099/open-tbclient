package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long jPJ;
    private static long jPK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cAv() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cAw() {
        return jPJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        jPJ = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cAx() {
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
        jPK = j;
    }

    public static long cAy() {
        return jPK;
    }
}
