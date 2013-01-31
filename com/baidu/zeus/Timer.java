package com.baidu.zeus;

import android.os.SystemClock;
/* loaded from: classes.dex */
class Timer {
    private long mLast;
    private long mStart;

    public Timer() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mLast = uptimeMillis;
        this.mStart = uptimeMillis;
    }

    public void mark(String str) {
        this.mLast = SystemClock.uptimeMillis();
    }
}
