package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c khL;
    private boolean khM = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cKg() {
        if (khL == null) {
            synchronized (c.class) {
                if (khL == null) {
                    khL = new c();
                }
            }
        }
        return khL;
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

    public boolean cKh() {
        return this.khM;
    }

    public void sL(boolean z) {
        this.khM = z;
    }
}
