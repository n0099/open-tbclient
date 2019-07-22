package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jhq;
    private long bck;
    private boolean jhr = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c cpV() {
        if (jhq == null) {
            synchronized (c.class) {
                if (jhq == null) {
                    jhq = new c();
                }
            }
        }
        return jhq;
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

    public boolean cpW() {
        return this.jhr;
    }

    public void rf(boolean z) {
        this.jhr = z;
    }
}
