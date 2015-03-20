package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int crP;
    private int crQ;
    private int crR;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.crR = 0;
        this.crQ = i;
        this.crP = i2;
        this.mType = i3;
        this.crR = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int amV() {
        return this.crP;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int amU() {
        return this.crQ;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int amW() {
        return this.crR;
    }

    public void iG(int i) {
        this.crR = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
