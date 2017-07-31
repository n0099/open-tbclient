package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c gjS;
    private boolean gjT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c bte() {
        if (gjS == null) {
            synchronized (c.class) {
                if (gjS == null) {
                    gjS = new c();
                }
            }
        }
        return gjS;
    }

    public long bnS() {
        return this.mTimeStamp;
    }

    public void cI(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean btf() {
        return this.gjT;
    }

    public void mz(boolean z) {
        this.gjT = z;
    }
}
