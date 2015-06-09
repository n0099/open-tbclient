package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d ctE;
    private long aEe;
    private boolean ctF = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static d api() {
        if (ctE == null) {
            synchronized (d.class) {
                if (ctE == null) {
                    ctE = new d();
                }
            }
        }
        return ctE;
    }

    public long Hl() {
        return this.aEe;
    }

    public void N(long j) {
        this.aEe = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean apj() {
        return this.ctF;
    }

    public void fh(boolean z) {
        this.ctF = z;
    }
}
