package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder {
    protected j bKR;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public View getRootView() {
        return this.rootView;
    }

    public void update(j jVar, int i, boolean z) {
        if (!jVar.bWN) {
            com.baidu.tbadk.distribute.a.uD().a(this.rootView.getContext(), jVar.agP(), "show", "pb", jVar.Gb, jVar.threadId);
            com.baidu.tbadk.distribute.a.uD().a(jVar.agP(), jVar.Gb, jVar.threadId, "PB", "show");
            jVar.bWN = true;
        }
        if (jVar != null) {
            com.baidu.tbadk.distribute.a.WK = jVar.aBV;
        }
        this.bKR = jVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.bKR, this.position, this.mIsFromCDN);
    }
}
