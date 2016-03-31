package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String aad;
    private int bsa;
    private long cUq;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.aad = str;
        this.mUrl = str2;
        this.cUq = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ci(int i) {
        this.bsa = i;
    }

    public void setNum(long j) {
        this.cUq = j;
    }

    public long getNum() {
        return this.cUq;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Je() {
        return this.aad;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jf() {
        return String.valueOf(this.cUq) + TbadkCoreApplication.m411getInst().getString(t.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jg() {
        return String.valueOf(this.bsa) + TbadkCoreApplication.m411getInst().getString(t.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Jh() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ji() {
        return this.bsa;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jj() {
        return this.mUrl;
    }
}
