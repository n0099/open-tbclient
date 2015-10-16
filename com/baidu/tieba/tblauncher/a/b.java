package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class b implements a {
    private int ddH;
    private int ddI;
    private int ddJ;
    private int mType;

    public b(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public b(int i, int i2, int i3, int i4) {
        this.ddJ = 0;
        this.ddI = i;
        this.ddH = i2;
        this.mType = i3;
        this.ddJ = i4;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayS() {
        return this.ddH;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayR() {
        return this.ddI;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayT() {
        return this.ddJ;
    }

    public void lp(int i) {
        this.ddJ = i;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public void onClick() {
    }
}
