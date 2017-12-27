package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hkN;
    private long eeW;
    private boolean hkO = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bCT() {
        if (hkN == null) {
            synchronized (c.class) {
                if (hkN == null) {
                    hkN = new c();
                }
            }
        }
        return hkN;
    }

    public long getTimeStamp() {
        return this.eeW;
    }

    public void cW(long j) {
        this.eeW = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bCU() {
        return this.hkO;
    }

    public void nz(boolean z) {
        this.hkO = z;
    }
}
