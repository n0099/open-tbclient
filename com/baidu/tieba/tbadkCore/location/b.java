package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b mTn;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean mTp = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dIa() {
        if (mTn == null) {
            synchronized (b.class) {
                if (mTn == null) {
                    mTn = new b();
                }
            }
        }
        return mTn;
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

    public boolean dIb() {
        return this.mTp;
    }

    public void xm(boolean z) {
        this.mTp = z;
    }
}
