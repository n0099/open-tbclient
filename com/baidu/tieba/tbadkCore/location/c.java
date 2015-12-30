package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c dIL;
    private long aSg;
    private boolean dIM = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aFW() {
        if (dIL == null) {
            synchronized (c.class) {
                if (dIL == null) {
                    dIL = new c();
                }
            }
        }
        return dIL;
    }

    public long Jl() {
        return this.aSg;
    }

    public void aq(long j) {
        this.aSg = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aFX() {
        return this.dIM;
    }

    public void hu(boolean z) {
        this.dIM = z;
    }
}
