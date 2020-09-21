package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b mqW;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean mqX = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dBg() {
        if (mqW == null) {
            synchronized (b.class) {
                if (mqW == null) {
                    mqW = new b();
                }
            }
        }
        return mqW;
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

    public boolean dBh() {
        return this.mqX;
    }

    public void wo(boolean z) {
        this.mqX = z;
    }
}
