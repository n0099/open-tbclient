package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c khG;
    private boolean khH = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cKe() {
        if (khG == null) {
            synchronized (c.class) {
                if (khG == null) {
                    khG = new c();
                }
            }
        }
        return khG;
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

    public boolean cKf() {
        return this.khH;
    }

    public void sL(boolean z) {
        this.khH = z;
    }
}
