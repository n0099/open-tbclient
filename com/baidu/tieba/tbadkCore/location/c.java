package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gsp;
    private long diL;
    private boolean gsq = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bvm() {
        if (gsp == null) {
            synchronized (c.class) {
                if (gsp == null) {
                    gsp = new c();
                }
            }
        }
        return gsp;
    }

    public long getTimeStamp() {
        return this.diL;
    }

    public void cF(long j) {
        this.diL = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bvn() {
        return this.gsq;
    }

    public void mG(boolean z) {
        this.gsq = z;
    }
}
