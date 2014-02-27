package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class dd implements AbsListView.OnScrollListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.h;
        runnable = this.a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.a.h;
        runnable2 = this.a.r;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
