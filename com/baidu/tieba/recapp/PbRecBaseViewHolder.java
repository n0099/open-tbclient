package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected View aAh;
    protected r dUi;
    protected boolean mIsFromCDN;
    private int position;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.aAh;
    }

    public void update(r rVar, int i, boolean z) {
        if (!rVar.epE) {
            com.baidu.tbadk.distribute.a.CR().a(this.aAh.getContext(), rVar.aTm(), "show", "pb", rVar.epF, rVar.threadId);
            com.baidu.tbadk.distribute.a.CR().a(rVar.aTm(), rVar.epF, rVar.threadId, "PB", "show", rVar.pageNumber);
            rVar.epE = true;
        }
        if (rVar != null) {
            com.baidu.tbadk.distribute.a.asE = rVar.bsz;
        }
        this.dUi = rVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.aAh.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (this.dUi != null) {
            if (!this.dUi.epE) {
                com.baidu.tbadk.distribute.a.CR().a(this.aAh.getContext(), this.dUi.aTm(), "show", "pb", this.dUi.epF, this.dUi.threadId);
                com.baidu.tbadk.distribute.a.CR().a(this.dUi.aTm(), this.dUi.epF, this.dUi.threadId, "PB", "show", this.dUi.pageNumber);
                this.dUi.epE = true;
            }
            if (this.dUi != null) {
                com.baidu.tbadk.distribute.a.asE = this.dUi.bsz;
            }
        }
    }
}
