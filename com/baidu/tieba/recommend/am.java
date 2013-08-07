package com.baidu.tieba.recommend;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FindInterestFragment findInterestFragment) {
        this.f1641a = findInterestFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        if (i == 0) {
            handler = this.f1641a.c;
            runnable = this.f1641a.i;
            handler.removeCallbacks(runnable);
            handler2 = this.f1641a.c;
            runnable2 = this.f1641a.i;
            handler2.postDelayed(runnable2, 300L);
        }
    }
}
