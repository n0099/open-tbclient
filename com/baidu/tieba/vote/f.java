package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String WB;
    private long dGZ;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.WB = str;
        this.mUrl = str2;
        this.dGZ = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.dGZ = j;
    }

    public long getNum() {
        return this.dGZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hv() {
        return this.WB;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hw() {
        return String.valueOf(this.dGZ) + TbadkCoreApplication.m10getInst().getString(u.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hx() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m10getInst().getString(u.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hy() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hz() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HA() {
        return this.mUrl;
    }
}
