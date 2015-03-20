package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends am {
    protected i bXj;
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
        if (!iVar.cnO) {
            com.baidu.tbadk.distribute.a.ye().a(this.rootView.getContext(), iVar.amw(), "show", "pb", iVar.cnP, iVar.threadId);
            com.baidu.tbadk.distribute.a.ye().a(iVar.amw(), iVar.cnP, iVar.threadId, "PB", "show");
            iVar.cnO = true;
        }
        if (iVar != null) {
            com.baidu.tbadk.distribute.a.aht = iVar.aNi;
        }
        this.bXj = iVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.bXj, this.position, this.mIsFromCDN);
    }
}
