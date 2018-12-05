package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hnt;
    private boolean hnu = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bDX() {
        if (hnt == null) {
            synchronized (c.class) {
                if (hnt == null) {
                    hnt = new c();
                }
            }
        }
        return hnt;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void de(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bDY() {
        return this.hnu;
    }

    public void nw(boolean z) {
        this.hnu = z;
    }
}
