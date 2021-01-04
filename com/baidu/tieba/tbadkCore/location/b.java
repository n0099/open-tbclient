package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nua;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nub = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dPQ() {
        if (nua == null) {
            synchronized (b.class) {
                if (nua == null) {
                    nua = new b();
                }
            }
        }
        return nua;
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

    public boolean dPR() {
        return this.nub;
    }

    public void ym(boolean z) {
        this.nub = z;
    }
}
