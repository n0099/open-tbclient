package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c caj;
    private long aus;
    private boolean cak = com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ahX() {
        if (caj == null) {
            synchronized (c.class) {
                if (caj == null) {
                    caj = new c();
                }
            }
        }
        return caj;
    }

    public long Dg() {
        return this.aus;
    }

    public void H(long j) {
        this.aus = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ahY() {
        return this.cak;
    }

    public void eD(boolean z) {
        this.cak = z;
    }
}
