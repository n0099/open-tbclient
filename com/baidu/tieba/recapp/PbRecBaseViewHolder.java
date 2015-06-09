package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends am {
    protected i cbd;
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
        if (!iVar.csd) {
            com.baidu.tbadk.distribute.a.yY().a(this.rootView.getContext(), iVar.aoy(), "show", "pb", iVar.cse, iVar.threadId);
            com.baidu.tbadk.distribute.a.yY().a(iVar.aoy(), iVar.cse, iVar.threadId, "PB", "show");
            iVar.csd = true;
        }
        if (iVar != null) {
            com.baidu.tbadk.distribute.a.aiC = iVar.aPM;
        }
        this.cbd = iVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cbd, this.position, this.mIsFromCDN);
    }
}
