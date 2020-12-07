package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b non;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean noo = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dPT() {
        if (non == null) {
            synchronized (b.class) {
                if (non == null) {
                    non = new b();
                }
            }
        }
        return non;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public LocationData getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(LocationData locationData) {
        this.mLocationData = locationData;
    }

    public boolean dPU() {
        return this.noo;
    }

    public void yh(boolean z) {
        this.noo = z;
    }
}
