package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.tbadkCore.f.a {
    private int cwq;
    private int cwr;
    private int cws;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cws = 0;
        this.cwr = i;
        this.cwq = i2;
        this.mType = i3;
        this.cws = i4;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apc() {
        return this.cwq;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apb() {
        return this.cwr;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public int apd() {
        return this.cws;
    }

    public void jf(int i) {
        this.cws = i;
    }

    @Override // com.baidu.tieba.tbadkCore.f.a
    public void onClick() {
    }
}
