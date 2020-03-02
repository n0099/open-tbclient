package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kiP;
    private boolean kiQ = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cLG() {
        if (kiP == null) {
            synchronized (c.class) {
                if (kiP == null) {
                    kiP = new c();
                }
            }
        }
        return kiP;
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

    public boolean cLH() {
        return this.kiQ;
    }

    public void sP(boolean z) {
        this.kiQ = z;
    }
}
