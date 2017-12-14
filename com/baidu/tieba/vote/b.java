package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private long aAU;
    private int aAV;
    private String afc;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.afc = str;
        this.mUrl = str2;
        this.aAU = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aAV = i;
    }

    public void setNum(long j) {
        this.aAU = j;
    }

    public long getNum() {
        return this.aAU;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return this.afc;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.aAU + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CK() {
        return this.aAV + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CM() {
        return this.aAV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CN() {
        return this.mUrl;
    }
}
