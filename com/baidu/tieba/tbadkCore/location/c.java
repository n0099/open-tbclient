package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c cKg;
    private long aLD;
    private boolean cKh = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aqC() {
        if (cKg == null) {
            synchronized (c.class) {
                if (cKg == null) {
                    cKg = new c();
                }
            }
        }
        return cKg;
    }

    public long Ia() {
        return this.aLD;
    }

    public void P(long j) {
        this.aLD = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aqD() {
        return this.cKh;
    }

    public void fz(boolean z) {
        this.cKh = z;
    }
}
