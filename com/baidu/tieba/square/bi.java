package com.baidu.tieba.square;

import android.widget.AbsListView;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SquareSearchActivity squareSearchActivity) {
        this.f2403a = squareSearchActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2 || i == 1) {
            UtilHelper.a(this.f2403a, absListView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
