package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c jjR;
    private boolean jjS = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c coU() {
        if (jjR == null) {
            synchronized (c.class) {
                if (jjR == null) {
                    jjR = new c();
                }
            }
        }
        return jjR;
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

    public boolean coV() {
        return this.jjS;
    }

    public void qS(boolean z) {
        this.jjS = z;
    }
}
