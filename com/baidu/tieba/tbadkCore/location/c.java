package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c dcX;
    private long aJN;
    private boolean dcY = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c ayr() {
        if (dcX == null) {
            synchronized (c.class) {
                if (dcX == null) {
                    dcX = new c();
                }
            }
        }
        return dcX;
    }

    public long HB() {
        return this.aJN;
    }

    public void ah(long j) {
        this.aJN = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean ays() {
        return this.dcY;
    }

    public void gA(boolean z) {
        this.dcY = z;
    }
}
