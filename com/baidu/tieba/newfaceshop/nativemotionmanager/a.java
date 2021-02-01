package com.baidu.tieba.newfaceshop.nativemotionmanager;
/* loaded from: classes9.dex */
public class a {
    private static a lCE;
    private volatile boolean jeU = false;

    private a() {
    }

    public void TP() {
        this.jeU = false;
    }

    public void sV(boolean z) {
        this.jeU = z;
    }

    public boolean bKX() {
        return this.jeU;
    }

    public static a diR() {
        if (lCE == null) {
            lCE = new a();
        }
        return lCE;
    }
}
