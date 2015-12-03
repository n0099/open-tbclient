package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected n dhH;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void update(n nVar, int i, boolean z) {
        if (!nVar.dzw) {
            com.baidu.tbadk.distribute.a.Bf().a(this.rootView.getContext(), nVar.aCX(), "show", "pb", nVar.dzx, nVar.threadId);
            com.baidu.tbadk.distribute.a.Bf().a(nVar.aCX(), nVar.dzx, nVar.threadId, "PB", "show", nVar.pageNumber);
            nVar.dzw = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.apR = nVar.bgO;
        }
        this.dhH = nVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (!this.dhH.dzw) {
            com.baidu.tbadk.distribute.a.Bf().a(this.rootView.getContext(), this.dhH.aCX(), "show", "pb", this.dhH.dzx, this.dhH.threadId);
            com.baidu.tbadk.distribute.a.Bf().a(this.dhH.aCX(), this.dhH.dzx, this.dhH.threadId, "PB", "show", this.dhH.pageNumber);
            this.dhH.dzw = true;
        }
        if (this.dhH != null) {
            com.baidu.tbadk.distribute.a.apR = this.dhH.bgO;
        }
    }
}
