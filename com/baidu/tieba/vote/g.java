package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.widget.vote.a {
    private String Zu;
    private long ati;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public g(int i, String str, String str2, long j) {
        this.mId = i;
        this.Zu = str;
        this.mUrl = str2;
        this.ati = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void cj(int i) {
        this.mPercent = i;
    }

    public void setNum(long j) {
        this.ati = j;
    }

    public long getNum() {
        return this.ati;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ce() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return String.valueOf(this.ati) + TbadkCoreApplication.m9getInst().getString(r.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cg() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(r.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ch() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ci() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cj() {
        return this.mUrl;
    }
}
