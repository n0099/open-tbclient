package com.baidu.tieba.location;
/* loaded from: classes.dex */
public class c {
    private static c blL;
    private long blM;
    private boolean blN = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c So() {
        if (blL == null) {
            synchronized (c.class) {
                if (blL == null) {
                    blL = new c();
                }
            }
        }
        return blL;
    }

    public long KE() {
        return this.blM;
    }

    public void V(long j) {
        this.blM = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean Sp() {
        return this.blN;
    }

    public void dw(boolean z) {
        this.blN = z;
    }
}
