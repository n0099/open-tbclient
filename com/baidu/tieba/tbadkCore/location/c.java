package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hqF;
    private boolean hqG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bEO() {
        if (hqF == null) {
            synchronized (c.class) {
                if (hqF == null) {
                    hqF = new c();
                }
            }
        }
        return hqF;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void dj(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bEP() {
        return this.hqG;
    }

    public void nz(boolean z) {
        this.hqG = z;
    }
}
