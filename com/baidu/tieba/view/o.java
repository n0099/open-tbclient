package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ n fMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fMj = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        v vVar2;
        vVar = this.fMj.fMi;
        if (vVar != null) {
            vVar2 = this.fMj.fMi;
            vVar2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        v vVar;
        v vVar2;
        this.fMj.RP();
        this.fMj.RQ();
        vVar = this.fMj.fMi;
        if (vVar != null) {
            vVar2 = this.fMj.fMi;
            vVar2.onScroll(absListView, i, i2, i3);
        }
    }
}
