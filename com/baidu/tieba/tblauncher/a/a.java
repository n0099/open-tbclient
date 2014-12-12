package com.baidu.tieba.tblauncher.a;
/* loaded from: classes.dex */
public class a {
    private int ccf;
    private int ccg;
    private int cch;
    private int mType;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public a(int i, int i2, int i3, int i4) {
        this.cch = 0;
        this.ccg = i;
        this.ccf = i2;
        this.mType = i3;
        this.cch = i4;
    }

    public int ajh() {
        return this.ccf;
    }

    public int aji() {
        return this.ccg;
    }

    public int getType() {
        return this.mType;
    }

    public int ajj() {
        return this.cch;
    }

    public void ij(int i) {
        this.cch = i;
    }
}
