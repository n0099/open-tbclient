package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends am {
    protected i bXz;
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
        if (!iVar.coe) {
            com.baidu.tbadk.distribute.a.yk().a(this.rootView.getContext(), iVar.amL(), "show", "pb", iVar.cof, iVar.threadId);
            com.baidu.tbadk.distribute.a.yk().a(iVar.amL(), iVar.cof, iVar.threadId, "PB", "show");
            iVar.coe = true;
        }
        if (iVar != null) {
            com.baidu.tbadk.distribute.a.ahB = iVar.aNz;
        }
        this.bXz = iVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.bXz, this.position, this.mIsFromCDN);
    }
}
