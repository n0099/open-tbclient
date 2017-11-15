package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private long aAo;
    private int aAp;
    private String aeM;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.aeM = str;
        this.mUrl = str2;
        this.aAo = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aAp = i;
    }

    public void setNum(long j) {
        this.aAo = j;
    }

    public long getNum() {
        return this.aAo;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return this.aeM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return this.aAo + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return this.aAp + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CB() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return this.aAp;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CD() {
        return this.mUrl;
    }
}
