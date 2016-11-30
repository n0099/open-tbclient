package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ n gfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.gfR = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        v vVar2;
        vVar = this.gfR.gfP;
        if (vVar != null) {
            vVar2 = this.gfR.gfP;
            vVar2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        v vVar;
        v vVar2;
        this.gfR.aSr();
        this.gfR.btm();
        vVar = this.gfR.gfP;
        if (vVar != null) {
            vVar2 = this.gfR.gfP;
            vVar2.onScroll(absListView, i, i2, i3);
        }
    }
}
