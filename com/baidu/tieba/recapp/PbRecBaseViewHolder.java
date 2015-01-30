package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder {
    protected j bMC;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public View getRootView() {
        return this.rootView;
    }

    public void update(j jVar, int i, boolean z) {
        if (!jVar.bYF) {
            com.baidu.tbadk.distribute.a.uU().a(this.rootView.getContext(), jVar.ahu(), "show", "pb", jVar.bYG, jVar.threadId);
            com.baidu.tbadk.distribute.a.uU().a(jVar.ahu(), jVar.bYG, jVar.threadId, "PB", "show");
            jVar.bYF = true;
        }
        if (jVar != null) {
            com.baidu.tbadk.distribute.a.Xq = jVar.aCW;
        }
        this.bMC = jVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.bMC, this.position, this.mIsFromCDN);
    }
}
