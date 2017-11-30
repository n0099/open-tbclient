package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gBl;
    private long drH;
    private boolean gBm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bwW() {
        if (gBl == null) {
            synchronized (c.class) {
                if (gBl == null) {
                    gBl = new c();
                }
            }
        }
        return gBl;
    }

    public long getTimeStamp() {
        return this.drH;
    }

    public void cM(long j) {
        this.drH = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bwX() {
        return this.gBm;
    }

    public void nd(boolean z) {
        this.gBm = z;
    }
}
