package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ n fJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fJN = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        v vVar2;
        vVar = this.fJN.fJM;
        if (vVar != null) {
            vVar2 = this.fJN.fJM;
            vVar2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        v vVar;
        v vVar2;
        this.fJN.QN();
        this.fJN.QO();
        vVar = this.fJN.fJM;
        if (vVar != null) {
            vVar2 = this.fJN.fJM;
            vVar2.onScroll(absListView, i, i2, i3);
        }
    }
}
