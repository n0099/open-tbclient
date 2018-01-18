package com.baidu.tieba.tbadkCore.location;
/* loaded from: classes.dex */
public class c {
    private static c hao;
    private long egn;
    private boolean hap = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("no_longer_show_address", false);
    private a mLocationData;

    public static c bwp() {
        if (hao == null) {
            synchronized (c.class) {
                if (hao == null) {
                    hao = new c();
                }
            }
        }
        return hao;
    }

    public long getTimeStamp() {
        return this.egn;
    }

    public void cO(long j) {
        this.egn = j;
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void b(a aVar) {
        this.mLocationData = aVar;
    }

    public boolean bwq() {
        return this.hap;
    }

    public void mB(boolean z) {
        this.hap = z;
    }
}
