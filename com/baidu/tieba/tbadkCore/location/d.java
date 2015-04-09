package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d cpC;
    private long aCc;
    private boolean cpD = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static d anq() {
        if (cpC == null) {
            synchronized (d.class) {
                if (cpC == null) {
                    cpC = new d();
                }
            }
        }
        return cpC;
    }

    public long Gh() {
        return this.aCc;
    }

    public void M(long j) {
        this.aCc = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean anr() {
        return this.cpD;
    }

    public void eO(boolean z) {
        this.cpD = z;
    }
}
