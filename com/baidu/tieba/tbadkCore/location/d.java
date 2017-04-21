package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d fAc;
    private boolean fAd = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static d bjV() {
        if (fAc == null) {
            synchronized (d.class) {
                if (fAc == null) {
                    fAc = new d();
                }
            }
        }
        return fAc;
    }

    public long avp() {
        return this.mTimeStamp;
    }

    public void cz(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bjW() {
        return this.fAd;
    }

    public void lv(boolean z) {
        this.fAd = z;
    }
}
