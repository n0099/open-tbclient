package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c giB;
    private long daC;
    private boolean giC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c brW() {
        if (giB == null) {
            synchronized (c.class) {
                if (giB == null) {
                    giB = new c();
                }
            }
        }
        return giB;
    }

    public long bmD() {
        return this.daC;
    }

    public void cC(long j) {
        this.daC = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean brX() {
        return this.giC;
    }

    public void mC(boolean z) {
        this.giC = z;
    }
}
