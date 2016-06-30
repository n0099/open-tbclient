package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends y.a {
    protected View axa;
    protected r eGv;
    protected boolean mIsFromCDN;
    private int position;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.axa;
    }

    public void update(r rVar, int i, boolean z) {
        if (!rVar.eXD) {
            com.baidu.tbadk.distribute.a.AU().a(this.axa.getContext(), rVar.bcg(), "show", "pb", rVar.bgH, rVar.threadId);
            com.baidu.tbadk.distribute.a.AU().a(rVar.bcg(), rVar.bgH, rVar.threadId, "PB", "show", rVar.pageNumber);
            rVar.eXD = true;
        }
        if (rVar != null) {
            com.baidu.tbadk.distribute.a.apj = rVar.bMN;
        }
        this.eGv = rVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.axa.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (this.eGv != null) {
            if (!this.eGv.eXD) {
                com.baidu.tbadk.distribute.a.AU().a(this.axa.getContext(), this.eGv.bcg(), "show", "pb", this.eGv.bgH, this.eGv.threadId);
                com.baidu.tbadk.distribute.a.AU().a(this.eGv.bcg(), this.eGv.bgH, this.eGv.threadId, "PB", "show", this.eGv.pageNumber);
                this.eGv.eXD = true;
            }
            if (this.eGv != null) {
                com.baidu.tbadk.distribute.a.apj = this.eGv.bMN;
            }
        }
    }

    public void setTheme(int i) {
    }

    public void updateFontSize() {
    }
}
