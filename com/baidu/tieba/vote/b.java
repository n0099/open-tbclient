package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private int aRP;
    private String aUX;
    private long brz;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.aUX = str;
        this.mUrl = str2;
        this.brz = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aRP = i;
    }

    public void setNum(long j) {
        this.brz = j;
    }

    public long getNum() {
        return this.brz;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return this.aUX;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return this.brz + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KI() {
        return this.aRP + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KK() {
        return this.aRP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KL() {
        return this.mUrl;
    }
}
