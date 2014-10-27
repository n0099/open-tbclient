package com.baidu.tieba.mygiftlist;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ k btD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.btD = kVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        if (i == 0) {
            view2 = this.btD.btB;
            view2.setVisibility(0);
            return;
        }
        view = this.btD.btB;
        view.setVisibility(8);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
