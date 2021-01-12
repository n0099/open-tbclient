package com.baidu.tieba.newfaceshop.nativemotionmanager;
/* loaded from: classes8.dex */
public class a {
    private static a luA;
    private volatile boolean iZn = false;

    private a() {
    }

    public void Si() {
        this.iZn = false;
    }

    public void sI(boolean z) {
        this.iZn = z;
    }

    public boolean bKD() {
        return this.iZn;
    }

    public static a dgQ() {
        if (luA == null) {
            luA = new a();
        }
        return luA;
    }
}
