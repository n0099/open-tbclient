package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c dYL;
    private long dSz;
    private boolean dYM = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aNb() {
        if (dYL == null) {
            synchronized (c.class) {
                if (dYL == null) {
                    dYL = new c();
                }
            }
        }
        return dYL;
    }

    public long afI() {
        return this.dSz;
    }

    public void bQ(long j) {
        this.dSz = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aNc() {
        return this.dYM;
    }

    public void hV(boolean z) {
        this.dYM = z;
    }
}
