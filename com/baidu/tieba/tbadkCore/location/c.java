package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c iIv;
    private long aYG;
    private boolean iIw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ceW() {
        if (iIv == null) {
            synchronized (c.class) {
                if (iIv == null) {
                    iIv = new c();
                }
            }
        }
        return iIv;
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

    public boolean ceX() {
        return this.iIw;
    }

    public void qa(boolean z) {
        this.iIw = z;
    }
}
