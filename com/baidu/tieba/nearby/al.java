package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPostActivity f1134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NearbyPostActivity nearbyPostActivity) {
        this.f1134a = nearbyPostActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1134a.m;
        runnable = this.f1134a.n;
        handler.removeCallbacks(runnable);
        handler2 = this.f1134a.m;
        runnable2 = this.f1134a.n;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
