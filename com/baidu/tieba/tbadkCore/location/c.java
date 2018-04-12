package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gyA;
    private long dFD;
    private boolean gyB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bsE() {
        if (gyA == null) {
            synchronized (c.class) {
                if (gyA == null) {
                    gyA = new c();
                }
            }
        }
        return gyA;
    }

    public long getTimeStamp() {
        return this.dFD;
    }

    public void cT(long j) {
        this.dFD = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsF() {
        return this.gyB;
    }

    public void ms(boolean z) {
        this.gyB = z;
    }
}
