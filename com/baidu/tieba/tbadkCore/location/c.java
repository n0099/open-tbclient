package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hgz;
    private boolean hgA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bCc() {
        if (hgz == null) {
            synchronized (c.class) {
                if (hgz == null) {
                    hgz = new c();
                }
            }
        }
        return hgz;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void cX(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bCd() {
        return this.hgA;
    }

    public void nu(boolean z) {
        this.hgA = z;
    }
}
