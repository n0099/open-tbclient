package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gQd;
    private long dZF;
    private boolean gQe = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bwO() {
        if (gQd == null) {
            synchronized (c.class) {
                if (gQd == null) {
                    gQd = new c();
                }
            }
        }
        return gQd;
    }

    public long getTimeStamp() {
        return this.dZF;
    }

    public void cR(long j) {
        this.dZF = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bwP() {
        return this.gQe;
    }

    public void mv(boolean z) {
        this.gQe = z;
    }
}
