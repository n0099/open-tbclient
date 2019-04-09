package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c iIa;
    private long aYL;
    private boolean iIb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ceV() {
        if (iIa == null) {
            synchronized (c.class) {
                if (iIa == null) {
                    iIa = new c();
                }
            }
        }
        return iIa;
    }

    public long getTimeStamp() {
        return this.aYL;
    }

    public void dO(long j) {
        this.aYL = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ceW() {
        return this.iIb;
    }

    public void qa(boolean z) {
        this.iIb = z;
    }
}
