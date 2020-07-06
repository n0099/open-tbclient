package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c lIh;
    private boolean lIi = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c diE() {
        if (lIh == null) {
            synchronized (c.class) {
                if (lIh == null) {
                    lIh = new c();
                }
            }
        }
        return lIh;
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

    public boolean diF() {
        return this.lIi;
    }

    public void uK(boolean z) {
        this.lIi = z;
    }
}
