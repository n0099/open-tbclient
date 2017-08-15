package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c glK;
    private boolean glL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static c btM() {
        if (glK == null) {
            synchronized (c.class) {
                if (glK == null) {
                    glK = new c();
                }
            }
        }
        return glK;
    }

    public long boz() {
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

    public boolean btN() {
        return this.glL;
    }

    public void mC(boolean z) {
        this.glL = z;
    }
}
