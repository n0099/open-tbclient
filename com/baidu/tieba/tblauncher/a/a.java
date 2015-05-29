package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int cwp;
    private int cwq;
    private int cwr;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cwr = 0;
        this.cwq = i;
        this.cwp = i2;
        this.mType = i3;
        this.cwr = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apb() {
        return this.cwp;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apa() {
        return this.cwq;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apc() {
        return this.cwr;
    }

    public void jf(int i) {
        this.cwr = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
