package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a {
    private int cdx;
    private int cdy;
    private int cdz;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cdz = 0;
        this.cdy = i;
        this.cdx = i2;
        this.mType = i3;
        this.cdz = i4;
    }

    public int ajy() {
        return this.cdx;
    }

    public int ajz() {
        return this.cdy;
    }

    public int getType() {
        return this.mType;
    }

    public int ajA() {
        return this.cdz;
    }

    public void io(int i) {
        this.cdz = i;
    }
}
