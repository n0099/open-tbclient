package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c lPx;
    private boolean lPy = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c dlN() {
        if (lPx == null) {
            synchronized (c.class) {
                if (lPx == null) {
                    lPx = new c();
                }
            }
        }
        return lPx;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean dlO() {
        return this.lPy;
    }

    public void vo(boolean z) {
        this.lPy = z;
    }
}
