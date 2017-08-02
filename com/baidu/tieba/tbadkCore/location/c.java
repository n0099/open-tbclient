package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c giH;
    private boolean giI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bsX() {
        if (giH == null) {
            synchronized (c.class) {
                if (giH == null) {
                    giH = new c();
                }
            }
        }
        return giH;
    }

    public long bnJ() {
        return this.mTimeStamp;
    }

    public void cI(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsY() {
        return this.giI;
    }

    public void mz(boolean z) {
        this.giI = z;
    }
}
