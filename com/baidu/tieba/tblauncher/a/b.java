package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class b implements a {
    private int ddh;
    private int ddi;
    private int ddj;
    private int mType;

    public b(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public b(int i, int i2, int i3, int i4) {
        this.ddj = 0;
        this.ddi = i;
        this.ddh = i2;
        this.mType = i3;
        this.ddj = i4;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayI() {
        return this.ddh;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayH() {
        return this.ddi;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public int ayJ() {
        return this.ddj;
    }

    public void ln(int i) {
        this.ddj = i;
    }

    @Override // com.baidu.tieba.tblauncher.a.a
    public void onClick() {
    }
}
