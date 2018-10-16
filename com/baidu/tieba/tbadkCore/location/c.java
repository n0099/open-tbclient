package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hfb;
    private boolean hfc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bCH() {
        if (hfb == null) {
            synchronized (c.class) {
                if (hfb == null) {
                    hfb = new c();
                }
            }
        }
        return hfb;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void dc(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bCI() {
        return this.hfc;
    }

    public void nj(boolean z) {
        this.hfc = z;
    }
}
