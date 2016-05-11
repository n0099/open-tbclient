package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends y.a {
    protected View awk;
    protected r dXa;
    protected boolean mIsFromCDN;
    private int position;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.awk;
    }

    public void update(r rVar, int i, boolean z) {
        if (!rVar.esO) {
            com.baidu.tbadk.distribute.a.AK().a(this.awk.getContext(), rVar.aTM(), "show", "pb", rVar.esP, rVar.threadId);
            com.baidu.tbadk.distribute.a.AK().a(rVar.aTM(), rVar.esP, rVar.threadId, "PB", "show", rVar.pageNumber);
            rVar.esO = true;
        }
        if (rVar != null) {
            com.baidu.tbadk.distribute.a.aov = rVar.brg;
        }
        this.dXa = rVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.awk.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (this.dXa != null) {
            if (!this.dXa.esO) {
                com.baidu.tbadk.distribute.a.AK().a(this.awk.getContext(), this.dXa.aTM(), "show", "pb", this.dXa.esP, this.dXa.threadId);
                com.baidu.tbadk.distribute.a.AK().a(this.dXa.aTM(), this.dXa.esP, this.dXa.threadId, "PB", "show", this.dXa.pageNumber);
                this.dXa.esO = true;
            }
            if (this.dXa != null) {
                com.baidu.tbadk.distribute.a.aov = this.dXa.brg;
            }
        }
    }

    public void setTheme(int i) {
    }

    public void updateFontSize() {
    }
}
