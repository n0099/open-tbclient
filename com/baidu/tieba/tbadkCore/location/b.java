package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nop;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean noq = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dPU() {
        if (nop == null) {
            synchronized (b.class) {
                if (nop == null) {
                    nop = new b();
                }
            }
        }
        return nop;
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

    public boolean dPV() {
        return this.noq;
    }

    public void yh(boolean z) {
        this.noq = z;
    }
}
