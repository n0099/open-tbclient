package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String Zb;
    private int aZF;
    private long bWZ;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.Zb = str;
        this.mUrl = str2;
        this.bWZ = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void lF(int i) {
        this.aZF = i;
    }

    public void setNum(long j) {
        this.bWZ = j;
    }

    public long getNum() {
        return this.bWZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fw() {
        return this.Zb;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fx() {
        return String.valueOf(this.bWZ) + TbadkCoreApplication.m411getInst().getString(i.h.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fy() {
        return String.valueOf(this.aZF) + TbadkCoreApplication.m411getInst().getString(i.h.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int FA() {
        return this.aZF;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String FB() {
        return this.mUrl;
    }
}
