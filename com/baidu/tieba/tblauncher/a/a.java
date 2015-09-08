package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int cVA;
    private int cVB;
    private int cVz;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cVB = 0;
        this.cVA = i;
        this.cVz = i2;
        this.mType = i3;
        this.cVB = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int auK() {
        return this.cVz;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int auJ() {
        return this.cVA;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int auL() {
        return this.cVB;
    }

    public void kK(int i) {
        this.cVB = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
