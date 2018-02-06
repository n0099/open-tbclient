package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hcW;
    private long ekU;
    private boolean hcX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bxA() {
        if (hcW == null) {
            synchronized (c.class) {
                if (hcW == null) {
                    hcW = new c();
                }
            }
        }
        return hcW;
    }

    public long getTimeStamp() {
        return this.ekU;
    }

    public void cP(long j) {
        this.ekU = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bxB() {
        return this.hcX;
    }

    public void mL(boolean z) {
        this.hcX = z;
    }
}
