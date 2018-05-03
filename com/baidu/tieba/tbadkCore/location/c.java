package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gyx;
    private long dFA;
    private boolean gyy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bsE() {
        if (gyx == null) {
            synchronized (c.class) {
                if (gyx == null) {
                    gyx = new c();
                }
            }
        }
        return gyx;
    }

    public long getTimeStamp() {
        return this.dFA;
    }

    public void cT(long j) {
        this.dFA = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsF() {
        return this.gyy;
    }

    public void ms(boolean z) {
        this.gyy = z;
    }
}
