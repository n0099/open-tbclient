package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gPe;
    private long dVQ;
    private boolean gPf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c byk() {
        if (gPe == null) {
            synchronized (c.class) {
                if (gPe == null) {
                    gPe = new c();
                }
            }
        }
        return gPe;
    }

    public long getTimeStamp() {
        return this.dVQ;
    }

    public void cU(long j) {
        this.dVQ = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean byl() {
        return this.gPf;
    }

    public void mK(boolean z) {
        this.gPf = z;
    }
}
