package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ n fuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fuJ = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        v vVar2;
        vVar = this.fuJ.fuH;
        if (vVar != null) {
            vVar2 = this.fuJ.fuH;
            vVar2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        v vVar;
        v vVar2;
        this.fuJ.bkl();
        this.fuJ.bkm();
        vVar = this.fuJ.fuH;
        if (vVar != null) {
            vVar2 = this.fuJ.fuH;
            vVar2.onScroll(absListView, i, i2, i3);
        }
    }
}
