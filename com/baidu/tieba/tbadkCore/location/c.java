package com.baidu.tieba.tbadkCore.location;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class c {
    private static c lov;
    private boolean lox = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, false);
    private a mLocationData;
    private long mTimeStamp;

    public static c der() {
        if (lov == null) {
            synchronized (c.class) {
                if (lov == null) {
                    lov = new c();
                }
            }
        }
        return lov;
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

    public boolean des() {
        return this.lox;
    }

    public void uv(boolean z) {
        this.lox = z;
    }
}
