package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String aef;
    private long ayM;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.aef = str;
        this.mUrl = str2;
        this.ayM = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void cg(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.ayM = j;
    }

    public long getNum() {
        return this.ayM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ck() {
        return this.aef;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return String.valueOf(this.ayM) + TbadkCoreApplication.m9getInst().getString(w.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cm() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(w.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cn() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Co() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cp() {
        return this.mUrl;
    }
}
