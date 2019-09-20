package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jkT;
    private long bcI;
    private boolean jkU = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c crf() {
        if (jkT == null) {
            synchronized (c.class) {
                if (jkT == null) {
                    jkT = new c();
                }
            }
        }
        return jkT;
    }

    public long getTimeStamp() {
        return this.bcI;
    }

    public void ez(long j) {
        this.bcI = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean crg() {
        return this.jkU;
    }

    public void rj(boolean z) {
        this.jkU = z;
    }
}
