package com.baidu.zeus;

import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes.dex */
class HttpLog {
    private static final boolean DEBUG = false;
    private static final String LOGTAG = "http";
    static final boolean LOGV = false;

    HttpLog() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(String str) {
        Log.v(LOGTAG, SystemClock.uptimeMillis() + " " + Thread.currentThread().getName() + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        Log.e(LOGTAG, str);
    }
}
