package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nBJ;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nBK = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dOB() {
        if (nBJ == null) {
            synchronized (b.class) {
                if (nBJ == null) {
                    nBJ = new b();
                }
            }
        }
        return nBJ;
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

    public boolean dOC() {
        return this.nBK;
    }

    public void yA(boolean z) {
        this.nBK = z;
    }
}
