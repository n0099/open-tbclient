package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends y.a {
    protected View axO;
    protected r eTx;
    protected boolean mIsFromCDN;
    private int position;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.axO;
    }

    public void update(r rVar, int i, boolean z) {
        if (!rVar.fkF) {
            com.baidu.tbadk.distribute.a.AU().a(this.axO.getContext(), rVar.bfv(), "show", "pb", rVar.bhU, rVar.threadId);
            com.baidu.tbadk.distribute.a.AU().a(rVar.bfv(), rVar.bhU, rVar.threadId, "PB", "show", rVar.pageNumber);
            rVar.fkF = true;
        }
        if (rVar != null) {
            com.baidu.tbadk.distribute.a.apZ = rVar.bOx;
        }
        this.eTx = rVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.axO.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (this.eTx != null) {
            if (!this.eTx.fkF) {
                com.baidu.tbadk.distribute.a.AU().a(this.axO.getContext(), this.eTx.bfv(), "show", "pb", this.eTx.bhU, this.eTx.threadId);
                com.baidu.tbadk.distribute.a.AU().a(this.eTx.bfv(), this.eTx.bhU, this.eTx.threadId, "PB", "show", this.eTx.pageNumber);
                this.eTx.fkF = true;
            }
            if (this.eTx != null) {
                com.baidu.tbadk.distribute.a.apZ = this.eTx.bOx;
            }
        }
    }

    public void setTheme(int i) {
    }

    public void updateFontSize() {
    }
}
