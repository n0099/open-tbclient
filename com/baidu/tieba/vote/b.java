package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private String aTq;
    private long boT;
    private int boU;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.aTq = str;
        this.mUrl = str2;
        this.boT = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.boU = i;
    }

    public void setNum(long j) {
        this.boT = j;
    }

    public long getNum() {
        return this.boT;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kj() {
        return this.aTq;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kk() {
        return this.boT + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kl() {
        return this.boU + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Km() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kn() {
        return this.boU;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ko() {
        return this.mUrl;
    }
}
