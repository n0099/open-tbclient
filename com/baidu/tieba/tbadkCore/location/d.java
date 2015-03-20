package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d cpm;
    private long aBU;
    private boolean cpn = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static d anb() {
        if (cpm == null) {
            synchronized (d.class) {
                if (cpm == null) {
                    cpm = new d();
                }
            }
        }
        return cpm;
    }

    public long Gb() {
        return this.aBU;
    }

    public void M(long j) {
        this.aBU = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean anc() {
        return this.cpn;
    }

    public void eQ(boolean z) {
        this.cpn = z;
    }
}
