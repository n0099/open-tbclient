package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c jkI;
    private boolean jkJ = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c coW() {
        if (jkI == null) {
            synchronized (c.class) {
                if (jkI == null) {
                    jkI = new c();
                }
            }
        }
        return jkI;
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

    public boolean coX() {
        return this.jkJ;
    }

    public void qS(boolean z) {
        this.jkJ = z;
    }
}
