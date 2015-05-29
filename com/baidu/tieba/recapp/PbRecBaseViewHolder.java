package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends am {
    protected i cbc;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void update(i iVar, int i, boolean z) {
        if (!iVar.csc) {
            com.baidu.tbadk.distribute.a.yX().a(this.rootView.getContext(), iVar.aox(), "show", "pb", iVar.csd, iVar.threadId);
            com.baidu.tbadk.distribute.a.yX().a(iVar.aox(), iVar.csd, iVar.threadId, "PB", "show");
            iVar.csc = true;
        }
        if (iVar != null) {
            com.baidu.tbadk.distribute.a.aiC = iVar.aPL;
        }
        this.cbc = iVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cbc, this.position, this.mIsFromCDN);
    }
}
