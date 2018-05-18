package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gzB;
    private long dGG;
    private boolean gzC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bsC() {
        if (gzB == null) {
            synchronized (c.class) {
                if (gzB == null) {
                    gzB = new c();
                }
            }
        }
        return gzB;
    }

    public long getTimeStamp() {
        return this.dGG;
    }

    public void cT(long j) {
        this.dGG = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsD() {
        return this.gzC;
    }

    public void mt(boolean z) {
        this.gzC = z;
    }
}
