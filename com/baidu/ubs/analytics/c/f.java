package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long jPF;
    private static long jPG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cAu() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long cAv() {
        return jPF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        jPF = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cAw() {
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
        jPG = j;
    }

    public static long cAx() {
        return jPG;
    }
}
