package com.baidu.tieba.write;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class i implements AbsListView.OnScrollListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.h;
        runnable = this.a.y;
        handler.removeCallbacks(runnable);
        handler2 = this.a.h;
        runnable2 = this.a.y;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
