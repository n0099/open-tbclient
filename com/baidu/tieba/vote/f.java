package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String aaR;
    private int bmP;
    private long cAV;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.aaR = str;
        this.mUrl = str2;
        this.cAV = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void cg(int i) {
        this.bmP = i;
    }

    public void setNum(long j) {
        this.cAV = j;
    }

    public long getNum() {
        return this.cAV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HI() {
        return this.aaR;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HJ() {
        return String.valueOf(this.cAV) + TbadkCoreApplication.m411getInst().getString(t.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HK() {
        return String.valueOf(this.bmP) + TbadkCoreApplication.m411getInst().getString(t.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HL() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HM() {
        return this.bmP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HN() {
        return this.mUrl;
    }
}
