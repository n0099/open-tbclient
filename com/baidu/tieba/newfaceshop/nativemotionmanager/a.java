package com.baidu.tieba.newfaceshop.nativemotionmanager;
/* loaded from: classes8.dex */
public class a {
    private static a lEU;
    private volatile boolean jgR = false;

    private a() {
    }

    public void TS() {
        this.jgR = false;
    }

    public void sV(boolean z) {
        this.jgR = z;
    }

    public boolean bLg() {
        return this.jgR;
    }

    public static a djh() {
        if (lEU == null) {
            lEU = new a();
        }
        return lEU;
    }
}
