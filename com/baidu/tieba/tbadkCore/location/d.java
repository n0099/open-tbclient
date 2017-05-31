package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class d {
    private static d fEd;
    private boolean fEe = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;
    private long mTimeStamp;

    public static d biM() {
        if (fEd == null) {
            synchronized (d.class) {
                if (fEd == null) {
                    fEd = new d();
                }
            }
        }
        return fEd;
    }

    public long ath() {
        return this.mTimeStamp;
    }

    public void cp(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean biN() {
        return this.fEe;
    }

    public void lu(boolean z) {
        this.fEe = z;
    }
}
