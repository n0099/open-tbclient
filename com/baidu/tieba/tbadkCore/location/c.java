package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jaT;
    private long bbz;
    private boolean jaU = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c cmZ() {
        if (jaT == null) {
            synchronized (c.class) {
                if (jaT == null) {
                    jaT = new c();
                }
            }
        }
        return jaT;
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

    public boolean cna() {
        return this.jaU;
    }

    public void qP(boolean z) {
        this.jaU = z;
    }
}
