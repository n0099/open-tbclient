package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c cSG;
    private long aLQ;
    private boolean cSH = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c auQ() {
        if (cSG == null) {
            synchronized (c.class) {
                if (cSG == null) {
                    cSG = new c();
                }
            }
        }
        return cSG;
    }

    public long HO() {
        return this.aLQ;
    }

    public void Q(long j) {
        this.aLQ = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean auR() {
        return this.cSH;
    }

    public void gk(boolean z) {
        this.cSH = z;
    }
}
