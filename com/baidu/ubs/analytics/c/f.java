package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class f {
    private static boolean ak = true;
    private static boolean al = false;
    private static long am = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;
    private static long jwO;
    private static long jwP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        am = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long csx() {
        return am;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long csy() {
        return jwO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        jwO = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean csz() {
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
        jwP = j;
    }

    public static long csA() {
        return jwP;
    }
}
