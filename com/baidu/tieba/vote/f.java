package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String adw;
    private long axK;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.adw = str;
        this.mUrl = str2;
        this.axK = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void cg(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.axK = j;
    }

    public long getNum() {
        return this.axK;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BQ() {
        return this.adw;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BR() {
        return String.valueOf(this.axK) + TbadkCoreApplication.m9getInst().getString(w.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BS() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(w.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int BT() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int BU() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BV() {
        return this.mUrl;
    }
}
