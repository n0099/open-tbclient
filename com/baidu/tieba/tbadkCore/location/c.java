package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c giP;
    private long daP;
    private boolean giQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bsd() {
        if (giP == null) {
            synchronized (c.class) {
                if (giP == null) {
                    giP = new c();
                }
            }
        }
        return giP;
    }

    public long bmK() {
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

    public boolean bse() {
        return this.giQ;
    }

    public void mD(boolean z) {
        this.giQ = z;
    }
}
