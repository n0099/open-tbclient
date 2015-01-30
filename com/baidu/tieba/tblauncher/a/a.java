package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a {
    private int cdA;
    private int cdy;
    private int cdz;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cdA = 0;
        this.cdz = i;
        this.cdy = i2;
        this.mType = i3;
        this.cdA = i4;
    }

    public int ajD() {
        return this.cdy;
    }

    public int ajE() {
        return this.cdz;
    }

    public int getType() {
        return this.mType;
    }

    public int ajF() {
        return this.cdA;
    }

    public void io(int i) {
        this.cdA = i;
    }
}
