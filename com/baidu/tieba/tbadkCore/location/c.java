package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c fuA;
    private a mLocationData;
    private boolean mNoLongerShowAddress = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("no_longer_show_address", false);
    private long mTimeStamp;

    public static c bjJ() {
        if (fuA == null) {
            synchronized (c.class) {
                if (fuA == null) {
                    fuA = new c();
                }
            }
        }
        return fuA;
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
