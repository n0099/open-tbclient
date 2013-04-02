package com.baidu.zeus;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.common.util.HanziToPinyin;
/* loaded from: classes.dex */
class HttpLog {
    private static final boolean DEBUG = false;
    private static final String LOGTAG = "http";
    static final boolean LOGV = false;

    HttpLog() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(String str) {
        Log.v(LOGTAG, SystemClock.uptimeMillis() + HanziToPinyin.Token.SEPARATOR + Thread.currentThread().getName() + HanziToPinyin.Token.SEPARATOR + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        Log.e(LOGTAG, str);
    }
}
