package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected n cIY;
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
        if (!nVar.daK) {
            com.baidu.tbadk.distribute.a.Ai().a(this.rootView.getContext(), nVar.axn(), "show", "pb", nVar.daL, nVar.threadId);
            com.baidu.tbadk.distribute.a.Ai().a(nVar.axn(), nVar.daL, nVar.threadId, "PB", "show", nVar.cJj);
            nVar.daK = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.anZ = nVar.baw;
        }
        this.cIY = nVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cIY, this.position, this.mIsFromCDN);
    }
}
