package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String VC;
    private int bnB;
    private long cWd;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.VC = str;
        this.mUrl = str2;
        this.cWd = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.bnB = i;
    }

    public void setNum(long j) {
        this.cWd = j;
    }

    public long getNum() {
        return this.cWd;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hu() {
        return this.VC;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hv() {
        return String.valueOf(this.cWd) + TbadkCoreApplication.m11getInst().getString(t.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hw() {
        return String.valueOf(this.bnB) + TbadkCoreApplication.m11getInst().getString(t.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hx() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hy() {
        return this.bnB;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hz() {
        return this.mUrl;
    }
}
