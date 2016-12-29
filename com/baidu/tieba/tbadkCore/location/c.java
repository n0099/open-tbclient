package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c fir;
    private long csw;
    private boolean fis = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bgE() {
        if (fir == null) {
            synchronized (c.class) {
                if (fir == null) {
                    fir = new c();
                }
            }
        }
        return fir;
    }

    public long atU() {
        return this.csw;
    }

    public void cE(long j) {
        this.csw = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bgF() {
        return this.fis;
    }

    public void kX(boolean z) {
        this.fis = z;
    }
}
