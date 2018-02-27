package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hcH;
    private long ekI;
    private boolean hcI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxz() {
        if (hcH == null) {
            synchronized (c.class) {
                if (hcH == null) {
                    hcH = new c();
                }
            }
        }
        return hcH;
    }

    public long getTimeStamp() {
        return this.ekI;
    }

    public void cP(long j) {
        this.ekI = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxA() {
        return this.hcI;
    }

    public void mL(boolean z) {
        this.hcI = z;
    }
}
