package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c dak;
    private long aKI;
    private boolean dal = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c axc() {
        if (dak == null) {
            synchronized (c.class) {
                if (dak == null) {
                    dak = new c();
                }
            }
        }
        return dak;
    }

    public long HI() {
        return this.aKI;
    }

    public void Z(long j) {
        this.aKI = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean axd() {
        return this.dal;
    }

    public void gu(boolean z) {
        this.dal = z;
    }
}
