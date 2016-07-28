package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c fmG;
    private a mLocationData;
    private boolean mNoLongerShowAddress = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("no_longer_show_address", false);
    private long mTimeStamp;

    public static c bgi() {
        if (fmG == null) {
            synchronized (c.class) {
                if (fmG == null) {
                    fmG = new c();
                }
            }
        }
        return fmG;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean isNoLongerShowAddress() {
        return this.mNoLongerShowAddress;
    }

    public void setNoLongerShowAddress(boolean z) {
        this.mNoLongerShowAddress = z;
    }
}
