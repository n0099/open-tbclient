package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c bYr;
    private long atw;
    private boolean bYs = com.baidu.tbadk.core.sharedPref.b.og().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ahy() {
        if (bYr == null) {
            synchronized (c.class) {
                if (bYr == null) {
                    bYr = new c();
                }
            }
        }
        return bYr;
    }

    public long CN() {
        return this.atw;
    }

    public void H(long j) {
        this.atw = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ahz() {
        return this.bYs;
    }

    public void ew(boolean z) {
        this.bYs = z;
    }
}
