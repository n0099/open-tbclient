package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AbsListView.OnScrollListener {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.l;
        runnable = this.a.m;
        handler.removeCallbacks(runnable);
        handler2 = this.a.l;
        runnable2 = this.a.m;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
