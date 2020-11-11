package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b mZm;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean mZn = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dKC() {
        if (mZm == null) {
            synchronized (b.class) {
                if (mZm == null) {
                    mZm = new b();
                }
            }
        }
        return mZm;
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

    public boolean dKD() {
        return this.mZn;
    }

    public void xv(boolean z) {
        this.mZn = z;
    }
}
