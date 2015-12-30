package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public abstract class PbRecBaseViewHolder extends x.a {
    protected q dnn;
    protected boolean mIsFromCDN;
    private int position;
    protected View rootView;

    public PbRecBaseViewHolder(View view) {
        super(view);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void update(q qVar, int i, boolean z) {
        if (!qVar.dGZ) {
            com.baidu.tbadk.distribute.a.AV().a(this.rootView.getContext(), qVar.aFk(), "show", "pb", qVar.dHa, qVar.threadId);
            com.baidu.tbadk.distribute.a.AV().a(qVar.aFk(), qVar.dHa, qVar.threadId, "PB", "show", qVar.pageNumber);
            qVar.dGZ = true;
        }
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.art = qVar.bkF;
        }
        this.dnn = qVar;
        this.position = i;
        this.mIsFromCDN = z;
        this.rootView.setTag(this);
    }

    public int getPosition() {
        return this.position;
    }

    public void refresh() {
        if (!this.dnn.dGZ) {
            com.baidu.tbadk.distribute.a.AV().a(this.rootView.getContext(), this.dnn.aFk(), "show", "pb", this.dnn.dHa, this.dnn.threadId);
            com.baidu.tbadk.distribute.a.AV().a(this.dnn.aFk(), this.dnn.dHa, this.dnn.threadId, "PB", "show", this.dnn.pageNumber);
            this.dnn.dGZ = true;
        }
        if (this.dnn != null) {
            com.baidu.tbadk.distribute.a.art = this.dnn.bkF;
        }
    }
}
