package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c giQ;
    private long daP;
    private boolean giR = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bse() {
        if (giQ == null) {
            synchronized (c.class) {
                if (giQ == null) {
                    giQ = new c();
                }
            }
        }
        return giQ;
    }

    public long bmL() {
        return this.daP;
    }

    public void cB(long j) {
        this.daP = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bsf() {
        return this.giR;
    }

    public void mD(boolean z) {
        this.giR = z;
    }
}
