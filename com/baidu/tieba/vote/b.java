package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private String aeB;
    private long azM;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.aeB = str;
        this.mUrl = str2;
        this.azM = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ci(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.azM = j;
    }

    public long getNum() {
        return this.azM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cw() {
        return this.aeB;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cx() {
        return this.azM + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return this.mPercent + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CA() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return this.mUrl;
    }
}
