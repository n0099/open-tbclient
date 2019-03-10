package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c iIw;
    private long aYG;
    private boolean iIx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ceX() {
        if (iIw == null) {
            synchronized (c.class) {
                if (iIw == null) {
                    iIw = new c();
                }
            }
        }
        return iIw;
    }

    public long getTimeStamp() {
        return this.aYG;
    }

    public void dO(long j) {
        this.aYG = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ceY() {
        return this.iIx;
    }

    public void qa(boolean z) {
        this.iIx = z;
    }
}
