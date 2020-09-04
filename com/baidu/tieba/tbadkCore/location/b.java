package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b mhw;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean mhx = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dxn() {
        if (mhw == null) {
            synchronized (b.class) {
                if (mhw == null) {
                    mhw = new b();
                }
            }
        }
        return mhw;
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

    public boolean dxo() {
        return this.mhx;
    }

    public void wf(boolean z) {
        this.mhx = z;
    }
}
