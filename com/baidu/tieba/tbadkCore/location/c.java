package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c ked;
    private boolean kee = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cJa() {
        if (ked == null) {
            synchronized (c.class) {
                if (ked == null) {
                    ked = new c();
                }
            }
        }
        return ked;
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

    public boolean cJb() {
        return this.kee;
    }

    public void sz(boolean z) {
        this.kee = z;
    }
}
