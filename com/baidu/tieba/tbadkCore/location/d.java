package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d fwl;
    private boolean fwm = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static d bhs() {
        if (fwl == null) {
            synchronized (d.class) {
                if (fwl == null) {
                    fwl = new d();
                }
            }
        }
        return fwl;
    }

    public long ask() {
        return this.mTimeStamp;
    }

    public void ck(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bht() {
        return this.fwm;
    }

    public void kZ(boolean z) {
        this.fwm = z;
    }
}
