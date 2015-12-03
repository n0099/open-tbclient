package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String ZR;
    private int bgb;
    private long cqm;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.ZR = str;
        this.mUrl = str2;
        this.cqm = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void nf(int i) {
        this.bgb = i;
    }

    public void setNum(long j) {
        this.cqm = j;
    }

    public long getNum() {
        return this.cqm;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gu() {
        return this.ZR;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gv() {
        return String.valueOf(this.cqm) + TbadkCoreApplication.m411getInst().getString(n.i.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gw() {
        return String.valueOf(this.bgb) + TbadkCoreApplication.m411getInst().getString(n.i.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gx() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gy() {
        return this.bgb;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gz() {
        return this.mUrl;
    }
}
