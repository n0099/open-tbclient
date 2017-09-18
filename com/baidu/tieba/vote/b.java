package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private long aAn;
    private int aAo;
    private String afg;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.afg = str;
        this.mUrl = str2;
        this.aAn = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ck(int i) {
        this.aAo = i;
    }

    public void setNum(long j) {
        this.aAn = j;
    }

    public long getNum() {
        return this.aAn;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return this.afg;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return this.aAn + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return this.aAo + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CD() {
        return this.aAo;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.mUrl;
    }
}
