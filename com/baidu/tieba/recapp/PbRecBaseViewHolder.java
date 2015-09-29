package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.j;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected j cHr;
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
        if (!jVar.cYD) {
            com.baidu.tbadk.distribute.a.Ag().a(this.rootView.getContext(), jVar.awt(), "show", "pb", jVar.cYE, jVar.threadId);
            com.baidu.tbadk.distribute.a.Ag().a(jVar.awt(), jVar.cYE, jVar.threadId, "PB", "show");
            jVar.cYD = true;
        }
        if (jVar != null) {
            com.baidu.tbadk.distribute.a.anT = jVar.aZR;
        }
        this.cHr = jVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cHr, this.position, this.mIsFromCDN);
    }
}
