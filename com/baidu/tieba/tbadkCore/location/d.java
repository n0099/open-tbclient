package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d ctD;
    private long aEd;
    private boolean ctE = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static d aph() {
        if (ctD == null) {
            synchronized (d.class) {
                if (ctD == null) {
                    ctD = new d();
                }
            }
        }
        return ctD;
    }

    public long Hk() {
        return this.aEd;
    }

    public void N(long j) {
        this.aEd = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean api() {
        return this.ctE;
    }

    public void fh(boolean z) {
        this.ctE = z;
    }
}
