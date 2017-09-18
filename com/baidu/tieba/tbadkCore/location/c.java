package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c glg;
    private long deB;
    private boolean glh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c btf() {
        if (glg == null) {
            synchronized (c.class) {
                if (glg == null) {
                    glg = new c();
                }
            }
        }
        return glg;
    }

    public long bnR() {
        return this.deB;
    }

    public void cD(long j) {
        this.deB = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean btg() {
        return this.glh;
    }

    public void mJ(boolean z) {
        this.glh = z;
    }
}
