package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gQc;
    private long dZI;
    private boolean gQd = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bwN() {
        if (gQc == null) {
            synchronized (c.class) {
                if (gQc == null) {
                    gQc = new c();
                }
            }
        }
        return gQc;
    }

    public long getTimeStamp() {
        return this.dZI;
    }

    public void cR(long j) {
        this.dZI = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bwO() {
        return this.gQd;
    }

    public void mv(boolean z) {
        this.gQd = z;
    }
}
