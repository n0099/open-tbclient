package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gLd;
    private long dRW;
    private boolean gLe = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxH() {
        if (gLd == null) {
            synchronized (c.class) {
                if (gLd == null) {
                    gLd = new c();
                }
            }
        }
        return gLd;
    }

    public long getTimeStamp() {
        return this.dRW;
    }

    public void cZ(long j) {
        this.dRW = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxI() {
        return this.gLe;
    }

    public void mz(boolean z) {
        this.gLe = z;
    }
}
