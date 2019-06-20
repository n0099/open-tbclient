package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c jaZ;
    private long bbz;
    private boolean jba = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c cnc() {
        if (jaZ == null) {
            synchronized (c.class) {
                if (jaZ == null) {
                    jaZ = new c();
                }
            }
        }
        return jaZ;
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

    public boolean cnd() {
        return this.jba;
    }

    public void qQ(boolean z) {
        this.jba = z;
    }
}
