package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b npv;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean npw = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dLZ() {
        if (npv == null) {
            synchronized (b.class) {
                if (npv == null) {
                    npv = new b();
                }
            }
        }
        return npv;
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

    public boolean dMa() {
        return this.npw;
    }

    public void yi(boolean z) {
        this.npw = z;
    }
}
