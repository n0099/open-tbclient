package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String VS;
    private int bHP;
    private long dCM;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.VS = str;
        this.mUrl = str2;
        this.dCM = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.bHP = i;
    }

    public void setNum(long j) {
        this.dCM = j;
    }

    public long getNum() {
        return this.dCM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hx() {
        return this.VS;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hy() {
        return String.valueOf(this.dCM) + TbadkCoreApplication.m9getInst().getString(u.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hz() {
        return String.valueOf(this.bHP) + TbadkCoreApplication.m9getInst().getString(u.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HA() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HB() {
        return this.bHP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HC() {
        return this.mUrl;
    }
}
