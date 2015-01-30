package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c cak;
    private long auv;
    private boolean cal = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aic() {
        if (cak == null) {
            synchronized (c.class) {
                if (cak == null) {
                    cak = new c();
                }
            }
        }
        return cak;
    }

    public long Dm() {
        return this.auv;
    }

    public void H(long j) {
        this.auv = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aid() {
        return this.cal;
    }

    public void eD(boolean z) {
        this.cal = z;
    }
}
