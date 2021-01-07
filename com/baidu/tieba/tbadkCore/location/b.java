package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b ntZ;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nua = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dPR() {
        if (ntZ == null) {
            synchronized (b.class) {
                if (ntZ == null) {
                    ntZ = new b();
                }
            }
        }
        return ntZ;
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

    public boolean dPS() {
        return this.nua;
    }

    public void ym(boolean z) {
        this.nua = z;
    }
}
