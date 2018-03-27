package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hdf;
    private long ekY;
    private boolean hdg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxE() {
        if (hdf == null) {
            synchronized (c.class) {
                if (hdf == null) {
                    hdf = new c();
                }
            }
        }
        return hdf;
    }

    public long getTimeStamp() {
        return this.ekY;
    }

    public void cP(long j) {
        this.ekY = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxF() {
        return this.hdg;
    }

    public void mQ(boolean z) {
        this.hdg = z;
    }
}
