package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nan;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nao = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dKB() {
        if (nan == null) {
            synchronized (b.class) {
                if (nan == null) {
                    nan = new b();
                }
            }
        }
        return nan;
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

    public boolean dKC() {
        return this.nao;
    }

    public void xC(boolean z) {
        this.nao = z;
    }
}
