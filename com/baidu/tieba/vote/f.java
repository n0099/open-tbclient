package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.widget.vote.a {
    private String YZ;
    private int aZu;
    private long bWO;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public f(int i, String str, String str2, long j) {
        this.mId = i;
        this.YZ = str;
        this.mUrl = str2;
        this.bWO = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void lD(int i) {
        this.aZu = i;
    }

    public void setNum(long j) {
        this.bWO = j;
    }

    public long getNum() {
        return this.bWO;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fw() {
        return this.YZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fx() {
        return String.valueOf(this.bWO) + TbadkCoreApplication.m411getInst().getString(i.h.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fy() {
        return String.valueOf(this.aZu) + TbadkCoreApplication.m411getInst().getString(i.h.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int FA() {
        return this.aZu;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String FB() {
        return this.mUrl;
    }
}
