package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String Zf;
    private int aZY;
    private long bXA;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.Zf = str;
        this.mUrl = str2;
        this.bXA = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void lT(int i) {
        this.aZY = i;
    }

    public void setNum(long j) {
        this.bXA = j;
    }

    public long getNum() {
        return this.bXA;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fp() {
        return this.Zf;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fq() {
        return String.valueOf(this.bXA) + TbadkCoreApplication.m411getInst().getString(i.h.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fr() {
        return String.valueOf(this.aZY) + TbadkCoreApplication.m411getInst().getString(i.h.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fs() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ft() {
        return this.aZY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fu() {
        return this.mUrl;
    }
}
