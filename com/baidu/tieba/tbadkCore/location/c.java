package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c dBi;
    private long aOo;
    private boolean dBj = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aDJ() {
        if (dBi == null) {
            synchronized (c.class) {
                if (dBi == null) {
                    dBi = new c();
                }
            }
        }
        return dBi;
    }

    public long IU() {
        return this.aOo;
    }

    public void ap(long j) {
        this.aOo = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aDK() {
        return this.dBj;
    }

    public void hl(boolean z) {
        this.dBj = z;
    }
}
