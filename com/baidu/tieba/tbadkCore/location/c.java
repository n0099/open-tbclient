package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c lnj;
    private boolean lnk = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c dec() {
        if (lnj == null) {
            synchronized (c.class) {
                if (lnj == null) {
                    lnj = new c();
                }
            }
        }
        return lnj;
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

    public boolean ded() {
        return this.lnk;
    }

    public void uv(boolean z) {
        this.lnk = z;
    }
}
