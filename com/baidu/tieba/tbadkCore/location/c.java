package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c iIo;
    private long aYH;
    private boolean iIp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ceZ() {
        if (iIo == null) {
            synchronized (c.class) {
                if (iIo == null) {
                    iIo = new c();
                }
            }
        }
        return iIo;
    }

    public long getTimeStamp() {
        return this.aYH;
    }

    public void dO(long j) {
        this.aYH = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean cfa() {
        return this.iIp;
    }

    public void qa(boolean z) {
        this.iIp = z;
    }
}
