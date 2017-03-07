package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c fwc;
    private long cAX;
    private boolean fwd = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bij() {
        if (fwc == null) {
            synchronized (c.class) {
                if (fwc == null) {
                    fwc = new c();
                }
            }
        }
        return fwc;
    }

    public long auv() {
        return this.cAX;
    }

    public void cz(long j) {
        this.cAX = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bik() {
        return this.fwd;
    }

    public void li(boolean z) {
        this.fwd = z;
    }
}
