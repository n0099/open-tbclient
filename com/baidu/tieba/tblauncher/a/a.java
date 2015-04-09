package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int csf;
    private int csg;
    private int csh;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.csh = 0;
        this.csg = i;
        this.csf = i2;
        this.mType = i3;
        this.csh = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int ank() {
        return this.csf;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int anj() {
        return this.csg;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int anl() {
        return this.csh;
    }

    public void iJ(int i) {
        this.csh = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
