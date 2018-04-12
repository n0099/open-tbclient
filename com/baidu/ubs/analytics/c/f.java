package com.baidu.ubs.analytics.c;

import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class f {
    private static long hkV;
    private static long hkW;
    private static boolean ak = true;
    private static boolean al = false;
    private static long hkU = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static boolean ap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        hkU = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEW() {
        return hkU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long bEX() {
        return hkV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j) {
        hkV = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bEY() {
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
        hkW = j;
    }

    public static long bEZ() {
        return hkW;
    }
}
