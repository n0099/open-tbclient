package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c frF;
    private long czB;
    private boolean frG = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bit() {
        if (frF == null) {
            synchronized (c.class) {
                if (frF == null) {
                    frF = new c();
                }
            }
        }
        return frF;
    }

    public long ava() {
        return this.czB;
    }

    public void cx(long j) {
        this.czB = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean biu() {
        return this.frG;
    }

    public void lj(boolean z) {
        this.frG = z;
    }
}
