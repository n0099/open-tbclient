package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private long aBf;
    private String afX;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.afX = str;
        this.mUrl = str2;
        this.aBf = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ck(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.aBf = j;
    }

    public long getNum() {
        return this.aBf;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.afX;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CF() {
        return this.aBf + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CG() {
        return this.mPercent + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CH() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CI() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.mUrl;
    }
}
