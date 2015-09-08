package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.h;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected h cAp;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void update(h hVar, int i, boolean z) {
        if (!hVar.cRd) {
            com.baidu.tbadk.distribute.a.Av().a(this.rootView.getContext(), hVar.aue(), "show", "pb", hVar.cRe, hVar.threadId);
            com.baidu.tbadk.distribute.a.Av().a(hVar.aue(), hVar.cRe, hVar.threadId, "PB", "show");
            hVar.cRd = true;
        }
        if (hVar != null) {
            com.baidu.tbadk.distribute.a.apu = hVar.aZY;
        }
        this.cAp = hVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.cAp, this.position, this.mIsFromCDN);
    }
}
