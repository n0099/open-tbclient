package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int cMS;
    private int cMT;
    private int cMU;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cMU = 0;
        this.cMT = i;
        this.cMS = i2;
        this.mType = i3;
        this.cMU = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int aqw() {
        return this.cMS;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int aqv() {
        return this.cMT;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int aqx() {
        return this.cMU;
    }

    public void jZ(int i) {
        this.cMU = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
