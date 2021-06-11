package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes6.dex */
public final class HardwareConfigState {
    public static final File FD_SIZE_LIST = new File("/proc/self/fd");
    public static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    public static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    public static final int MIN_HARDWARE_DIMENSION = 128;
    public static volatile HardwareConfigState instance;
    public volatile int decodesSinceLastFdCheck;
    public volatile boolean isHardwareConfigAllowed = true;

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z = true;
        int i2 = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i2;
        if (i2 >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            if (length >= 700) {
                z = false;
            }
            this.isHardwareConfigAllowed = z;
            if (!this.isHardwareConfigAllowed && Log.isLoggable(Downsampler.TAG, 5)) {
                Log.w(Downsampler.TAG, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.isHardwareConfigAllowed;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i2 >= 128 && i3 >= 128 && isFdSizeBelowHardwareLimit();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
