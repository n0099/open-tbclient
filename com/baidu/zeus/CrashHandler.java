package com.baidu.zeus;

import android.util.Log;
/* loaded from: classes.dex */
public class CrashHandler {
    static final String LOGTAG = "CrashHandler";

    public void onNativeCrash(int i, String str) {
        Log.e(LOGTAG, "signal: " + i + " info: " + str);
    }
}
