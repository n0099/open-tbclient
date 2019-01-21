package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hrO;
    private boolean hrP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bFx() {
        if (hrO == null) {
            synchronized (c.class) {
                if (hrO == null) {
                    hrO = new c();
                }
            }
        }
        return hrO;
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

    public boolean bFy() {
        return this.hrP;
    }

    public void nA(boolean z) {
        this.hrP = z;
    }
}
