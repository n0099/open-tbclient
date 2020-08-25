package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes2.dex */
public class b {
    private static b mhh;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean mhi = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dxi() {
        if (mhh == null) {
            synchronized (b.class) {
                if (mhh == null) {
                    mhh = new b();
                }
            }
        }
        return mhh;
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

    public boolean dxj() {
        return this.mhi;
    }

    public void wd(boolean z) {
        this.mhi = z;
    }
}
