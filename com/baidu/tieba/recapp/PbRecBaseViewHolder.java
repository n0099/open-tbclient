package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.j;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected j cHC;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void update(j jVar, int i, boolean z) {
        if (!jVar.cZd) {
            com.baidu.tbadk.distribute.a.Ad().a(this.rootView.getContext(), jVar.awz(), "show", "pb", jVar.cZe, jVar.threadId);
            com.baidu.tbadk.distribute.a.Ad().a(jVar.awz(), jVar.cZe, jVar.threadId, "PB", "show", jVar.cHN);
            jVar.cZd = true;
        }
        if (jVar != null) {
            com.baidu.tbadk.distribute.a.anU = jVar.bac;
        }
        this.cHC = jVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cHC, this.position, this.mIsFromCDN);
    }
}
