package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c lPv;
    private boolean lPw = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c dlM() {
        if (lPv == null) {
            synchronized (c.class) {
                if (lPv == null) {
                    lPv = new c();
                }
            }
        }
        return lPv;
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

    public boolean dlN() {
        return this.lPw;
    }

    public void vo(boolean z) {
        this.lPw = z;
    }
}
