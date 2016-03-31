package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c erD;
    private long ekZ;
    private boolean erE = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c aUd() {
        if (erD == null) {
            synchronized (c.class) {
                if (erD == null) {
                    erD = new c();
                }
            }
        }
        return erD;
    }

    public long ajc() {
        return this.ekZ;
    }

    public void ca(long j) {
        this.ekZ = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean aUe() {
        return this.erE;
    }

    public void iK(boolean z) {
        this.erE = z;
    }
}
