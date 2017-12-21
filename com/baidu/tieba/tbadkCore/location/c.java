package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gDZ;
    private long dsQ;
    private boolean gEa = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxD() {
        if (gDZ == null) {
            synchronized (c.class) {
                if (gDZ == null) {
                    gDZ = new c();
                }
            }
        }
        return gDZ;
    }

    public long getTimeStamp() {
        return this.dsQ;
    }

    public void cN(long j) {
        this.dsQ = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxE() {
        return this.gEa;
    }

    public void nf(boolean z) {
        this.gEa = z;
    }
}
