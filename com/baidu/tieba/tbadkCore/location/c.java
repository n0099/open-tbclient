package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c haI;
    private long egI;
    private boolean haJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bwr() {
        if (haI == null) {
            synchronized (c.class) {
                if (haI == null) {
                    haI = new c();
                }
            }
        }
        return haI;
    }

    public long getTimeStamp() {
        return this.egI;
    }

    public void cQ(long j) {
        this.egI = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bws() {
        return this.haJ;
    }

    public void mE(boolean z) {
        this.haJ = z;
    }
}
