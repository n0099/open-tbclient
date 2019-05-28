package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jaV;
    private long bbz;
    private boolean jaW = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c cnb() {
        if (jaV == null) {
            synchronized (c.class) {
                if (jaV == null) {
                    jaV = new c();
                }
            }
        }
        return jaV;
    }

    public long getTimeStamp() {
        return this.bbz;
    }

    public void em(long j) {
        this.bbz = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean cnc() {
        return this.jaW;
    }

    public void qP(boolean z) {
        this.jaW = z;
    }
}
