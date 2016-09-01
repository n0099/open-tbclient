package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ n fWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fWr = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        v vVar2;
        vVar = this.fWr.fWp;
        if (vVar != null) {
            vVar2 = this.fWr.fWp;
            vVar2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        v vVar;
        v vVar2;
        this.fWr.aPN();
        this.fWr.bqp();
        vVar = this.fWr.fWp;
        if (vVar != null) {
            vVar2 = this.fWr.fWp;
            vVar2.onScroll(absListView, i, i2, i3);
        }
    }
}
