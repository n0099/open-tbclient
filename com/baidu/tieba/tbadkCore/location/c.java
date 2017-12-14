package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gDU;
    private long dsM;
    private boolean gDV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxD() {
        if (gDU == null) {
            synchronized (c.class) {
                if (gDU == null) {
                    gDU = new c();
                }
            }
        }
        return gDU;
    }

    public long getTimeStamp() {
        return this.dsM;
    }

    public void cN(long j) {
        this.dsM = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxE() {
        return this.gDV;
    }

    public void nf(boolean z) {
        this.gDV = z;
    }
}
