package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* loaded from: classes5.dex */
public final class LogTime {
    public static final double MILLIS_MULTIPLIER;

    static {
        MILLIS_MULTIPLIER = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double getElapsedMillis(long j) {
        double logTime = getLogTime() - j;
        double d2 = MILLIS_MULTIPLIER;
        Double.isNaN(logTime);
        return logTime * d2;
    }

    @TargetApi(17)
    public static long getLogTime() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
