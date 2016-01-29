package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected View azA;
    protected q dCq;
    protected boolean mIsFromCDN;
    private int position;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.azA;
    }

    public void update(q qVar, int i, boolean z) {
        if (!qVar.dWV) {
            com.baidu.tbadk.distribute.a.Cl().a(this.azA.getContext(), qVar.aMq(), "show", "pb", qVar.dWW, qVar.threadId);
            com.baidu.tbadk.distribute.a.Cl().a(qVar.aMq(), qVar.dWW, qVar.threadId, "PB", "show", qVar.pageNumber);
            qVar.dWV = true;
        }
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.asm = qVar.bnC;
        }
        this.dCq = qVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.azA.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (!this.dCq.dWV) {
            com.baidu.tbadk.distribute.a.Cl().a(this.azA.getContext(), this.dCq.aMq(), "show", "pb", this.dCq.dWW, this.dCq.threadId);
            com.baidu.tbadk.distribute.a.Cl().a(this.dCq.aMq(), this.dCq.dWW, this.dCq.threadId, "PB", "show", this.dCq.pageNumber);
            this.dCq.dWV = true;
        }
        if (this.dCq != null) {
            com.baidu.tbadk.distribute.a.asm = this.dCq.bnC;
        }
    }
}
