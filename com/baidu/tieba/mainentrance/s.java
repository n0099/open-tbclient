package com.baidu.tieba.mainentrance;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
final class s implements AbsListView.OnScrollListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2 || i == 1) {
            BdUtilHelper.a(this.a, absListView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
