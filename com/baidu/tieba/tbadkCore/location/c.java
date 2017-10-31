package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c grm;
    private long dir;
    private boolean grn = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bva() {
        if (grm == null) {
            synchronized (c.class) {
                if (grm == null) {
                    grm = new c();
                }
            }
        }
        return grm;
    }

    public long getTimeStamp() {
        return this.dir;
    }

    public void cD(long j) {
        this.dir = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bvb() {
        return this.grn;
    }

    public void my(boolean z) {
        this.grn = z;
    }
}
