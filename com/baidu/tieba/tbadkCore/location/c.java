package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gXI;
    private long ehb;
    private boolean gXJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bzs() {
        if (gXI == null) {
            synchronized (c.class) {
                if (gXI == null) {
                    gXI = new c();
                }
            }
        }
        return gXI;
    }

    public long getTimeStamp() {
        return this.ehb;
    }

    public void cV(long j) {
        this.ehb = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bzt() {
        return this.gXJ;
    }

    public void mS(boolean z) {
        this.gXJ = z;
    }
}
