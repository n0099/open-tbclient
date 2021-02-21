package com.baidu.tieba.newfaceshop.nativemotionmanager;
/* loaded from: classes9.dex */
public class a {
    private static a lCS;
    private volatile boolean jfi = false;

    private a() {
    }

    public void TP() {
        this.jfi = false;
    }

    public void sV(boolean z) {
        this.jfi = z;
    }

    public boolean bLc() {
        return this.jfi;
    }

    public static a diY() {
        if (lCS == null) {
            lCS = new a();
        }
        return lCS;
    }
}
