package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.widget.vote.a {
    private String aTp;
    private long bpc;
    private int bpd;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public b(int i, String str, String str2, long j) {
        this.mId = i;
        this.aTp = str;
        this.mUrl = str2;
        this.bpc = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.bpd = i;
    }

    public void setNum(long j) {
        this.bpc = j;
    }

    public long getNum() {
        return this.bpc;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String JY() {
        return this.aTp;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String JZ() {
        return this.bpc + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ka() {
        return this.bpd + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kb() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kc() {
        return this.bpd;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kd() {
        return this.mUrl;
    }
}
