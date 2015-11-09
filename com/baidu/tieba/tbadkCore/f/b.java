package com.baidu.tieba.tbadkCore.f;
/* loaded from: classes.dex */
public class b implements a {
    private int dcu;
    private int dcv;
    private int dcw;
    private int mType;

    public b(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public b(int i, int i2, int i3, int i4) {
        this.dcw = 0;
        this.dcv = i;
        this.dcu = i2;
        this.mType = i3;
        this.dcw = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int axV() {
        return this.dcu;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int axU() {
        return this.dcv;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int axW() {
        return this.dcw;
    }

    public void lq(int i) {
        this.dcw = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
