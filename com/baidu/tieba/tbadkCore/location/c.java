package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hfc;
    private boolean hfd = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bCH() {
        if (hfc == null) {
            synchronized (c.class) {
                if (hfc == null) {
                    hfc = new c();
                }
            }
        }
        return hfc;
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
        return this.hfd;
    }

    public void nj(boolean z) {
        this.hfd = z;
    }
}
