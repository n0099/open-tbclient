package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kjb;
    private boolean kjc = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cLH() {
        if (kjb == null) {
            synchronized (c.class) {
                if (kjb == null) {
                    kjb = new c();
                }
            }
        }
        return kjb;
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

    public boolean cLI() {
        return this.kjc;
    }

    public void sP(boolean z) {
        this.kjc = z;
    }
}
