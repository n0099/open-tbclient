package com.baidu.tieba.mainentrance;

import android.widget.AbsListView;
/* loaded from: classes.dex */
final class q implements AbsListView.OnScrollListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2 || i == 1) {
            com.baidu.adp.lib.util.i.a(this.a, absListView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
