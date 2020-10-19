package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b mGE;
    private boolean mGF = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private LocationData mLocationData;
    private long mTimeStamp;

    public static b dES() {
        if (mGE == null) {
            synchronized (b.class) {
                if (mGE == null) {
                    mGE = new b();
                }
            }
        }
        return mGE;
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

    public boolean dET() {
        return this.mGF;
    }

    public void wV(boolean z) {
        this.mGF = z;
    }
}
