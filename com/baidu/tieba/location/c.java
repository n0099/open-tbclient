package com.baidu.tieba.location;
/* loaded from: classes.dex */
public class c {
    private static c blZ;
    private long bma;
    private boolean bmb = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c Sr() {
        if (blZ == null) {
            synchronized (c.class) {
                if (blZ == null) {
                    blZ = new c();
                }
            }
        }
        return blZ;
    }

    public long KI() {
        return this.bma;
    }

    public void V(long j) {
        this.bma = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean Ss() {
        return this.bmb;
    }

    public void dw(boolean z) {
        this.bmb = z;
    }
}
