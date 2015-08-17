package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.h;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected h crU;
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
        if (!hVar.cID) {
            com.baidu.tbadk.distribute.a.Ai().a(this.rootView.getContext(), hVar.apR(), "show", "pb", hVar.cIE, hVar.threadId);
            com.baidu.tbadk.distribute.a.Ai().a(hVar.apR(), hVar.cIE, hVar.threadId, "PB", "show");
            hVar.cID = true;
        }
        if (hVar != null) {
            com.baidu.tbadk.distribute.a.anJ = hVar.aZG;
        }
        this.crU = hVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        update(this.crU, this.position, this.mIsFromCDN);
    }
}
