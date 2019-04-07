package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c iHZ;
    private long aYK;
    private boolean iIa = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ceV() {
        if (iHZ == null) {
            synchronized (c.class) {
                if (iHZ == null) {
                    iHZ = new c();
                }
            }
        }
        return iHZ;
    }

    public long getTimeStamp() {
        return this.aYK;
    }

    public void dO(long j) {
        this.aYK = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ceW() {
        return this.iIa;
    }

    public void qa(boolean z) {
        this.iIa = z;
    }
}
