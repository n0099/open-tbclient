package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hrN;
    private boolean hrO = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bFx() {
        if (hrN == null) {
            synchronized (c.class) {
                if (hrN == null) {
                    hrN = new c();
                }
            }
        }
        return hrN;
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
        return this.hrO;
    }

    public void nA(boolean z) {
        this.hrO = z;
    }
}
