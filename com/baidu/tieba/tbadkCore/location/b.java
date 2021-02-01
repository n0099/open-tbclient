package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class b {
    private static b nze;
    private LocationData mLocationData;
    private long mTimeStamp;
    private boolean nzf = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);

    public static b dOk() {
        if (nze == null) {
            synchronized (b.class) {
                if (nze == null) {
                    nze = new b();
                }
            }
        }
        return nze;
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

    public boolean dOl() {
        return this.nzf;
    }

    public void yB(boolean z) {
        this.nzf = z;
    }
}
