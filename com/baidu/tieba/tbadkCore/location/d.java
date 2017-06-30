package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d fOi;
    private boolean fOj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static d bna() {
        if (fOi == null) {
            synchronized (d.class) {
                if (fOi == null) {
                    fOi = new d();
                }
            }
        }
        return fOi;
    }

    public long bkj() {
        return this.mTimeStamp;
    }

    public void cE(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bnb() {
        return this.fOj;
    }

    public void lT(boolean z) {
        this.fOj = z;
    }
}
