package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jiy;
    private long bck;
    private boolean jiz = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c cqr() {
        if (jiy == null) {
            synchronized (c.class) {
                if (jiy == null) {
                    jiy = new c();
                }
            }
        }
        return jiy;
    }

    public long getTimeStamp() {
        return this.bck;
    }

    public void ew(long j) {
        this.bck = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean cqs() {
        return this.jiz;
    }

    public void rg(boolean z) {
        this.jiz = z;
    }
}
