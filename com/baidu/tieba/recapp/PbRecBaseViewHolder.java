package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder {
    protected j bMB;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public View getRootView() {
        return this.rootView;
    }

    public void update(j jVar, int i, boolean z) {
        if (!jVar.bYE) {
            com.baidu.tbadk.distribute.a.uO().a(this.rootView.getContext(), jVar.ahp(), "show", "pb", jVar.bYF, jVar.threadId);
            com.baidu.tbadk.distribute.a.uO().a(jVar.ahp(), jVar.bYF, jVar.threadId, "PB", "show");
            jVar.bYE = true;
        }
        if (jVar != null) {
            com.baidu.tbadk.distribute.a.Xn = jVar.aCT;
        }
        this.bMB = jVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.bMB, this.position, this.mIsFromCDN);
    }
}
