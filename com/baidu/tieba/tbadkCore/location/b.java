package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nzE;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nzF = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dOs() {
        if (nzE == null) {
            synchronized (b.class) {
                if (nzE == null) {
                    nzE = new b();
                }
            }
        }
        return nzE;
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

    public boolean dOt() {
        return this.nzF;
    }

    public void yB(boolean z) {
        this.nzF = z;
    }
}
