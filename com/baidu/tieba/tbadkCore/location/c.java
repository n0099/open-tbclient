package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kiN;
    private boolean kiO = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cLE() {
        if (kiN == null) {
            synchronized (c.class) {
                if (kiN == null) {
                    kiN = new c();
                }
            }
        }
        return kiN;
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

    public boolean cLF() {
        return this.kiO;
    }

    public void sP(boolean z) {
        this.kiO = z;
    }
}
