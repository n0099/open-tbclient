package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gkm;
    private long ddF;
    private boolean gkn = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bsU() {
        if (gkm == null) {
            synchronized (c.class) {
                if (gkm == null) {
                    gkm = new c();
                }
            }
        }
        return gkm;
    }

    public long bnG() {
        return this.ddF;
    }

    public void cD(long j) {
        this.ddF = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsV() {
        return this.gkn;
    }

    public void mI(boolean z) {
        this.gkn = z;
    }
}
