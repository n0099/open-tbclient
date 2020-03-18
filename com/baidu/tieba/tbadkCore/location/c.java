package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kkD;
    private boolean kkE = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cMb() {
        if (kkD == null) {
            synchronized (c.class) {
                if (kkD == null) {
                    kkD = new c();
                }
            }
        }
        return kkD;
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

    public boolean cMc() {
        return this.kkE;
    }

    public void sV(boolean z) {
        this.kkE = z;
    }
}
