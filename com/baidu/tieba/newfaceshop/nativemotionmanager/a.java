package com.baidu.tieba.newfaceshop.nativemotionmanager;
/* loaded from: classes9.dex */
public class a {
    private static a lzg;
    private volatile boolean jdU = false;

    private a() {
    }

    public void Wb() {
        this.jdU = false;
    }

    public void sM(boolean z) {
        this.jdU = z;
    }

    public boolean bOv() {
        return this.jdU;
    }

    public static a dkI() {
        if (lzg == null) {
            lzg = new a();
        }
        return lzg;
    }
}
