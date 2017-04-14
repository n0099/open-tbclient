package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d fxM;
    private boolean fxN = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static d biU() {
        if (fxM == null) {
            synchronized (d.class) {
                if (fxM == null) {
                    fxM = new d();
                }
            }
        }
        return fxM;
    }

    public long auo() {
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

    public boolean biV() {
        return this.fxN;
    }

    public void ll(boolean z) {
        this.fxN = z;
    }
}
