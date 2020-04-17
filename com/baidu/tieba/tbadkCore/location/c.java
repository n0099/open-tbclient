package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kUJ;
    private boolean kUK = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cWX() {
        if (kUJ == null) {
            synchronized (c.class) {
                if (kUJ == null) {
                    kUJ = new c();
                }
            }
        }
        return kUJ;
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

    public boolean cWY() {
        return this.kUK;
    }

    public void tX(boolean z) {
        this.kUK = z;
    }
}
