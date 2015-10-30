package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c daM;
    private long aKT;
    private boolean daN = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c axi() {
        if (daM == null) {
            synchronized (c.class) {
                if (daM == null) {
                    daM = new c();
                }
            }
        }
        return daM;
    }

    public long HE() {
        return this.aKT;
    }

    public void ah(long j) {
        this.aKT = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean axj() {
        return this.daN;
    }

    public void gu(boolean z) {
        this.daN = z;
    }
}
