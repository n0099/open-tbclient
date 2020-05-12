package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c kUN;
    private boolean kUO = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c cWV() {
        if (kUN == null) {
            synchronized (c.class) {
                if (kUN == null) {
                    kUN = new c();
                }
            }
        }
        return kUN;
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

    public boolean cWW() {
        return this.kUO;
    }

    public void tX(boolean z) {
        this.kUO = z;
    }
}
