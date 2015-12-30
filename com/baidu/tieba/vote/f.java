package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String aav;
    private int bjT;
    private long cup;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.aav = str;
        this.mUrl = str2;
        this.cup = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void nX(int i) {
        this.bjT = i;
    }

    public void setNum(long j) {
        this.cup = j;
    }

    public long getNum() {
        return this.cup;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gj() {
        return this.aav;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gk() {
        return String.valueOf(this.cup) + TbadkCoreApplication.m411getInst().getString(n.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gl() {
        return String.valueOf(this.bjT) + TbadkCoreApplication.m411getInst().getString(n.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gn() {
        return this.bjT;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Go() {
        return this.mUrl;
    }
}
