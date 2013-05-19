package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements AbsListView.OnScrollListener {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonLbsActivity personLbsActivity) {
        this.a = personLbsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.u;
        runnable = this.a.v;
        handler.removeCallbacks(runnable);
        handler2 = this.a.u;
        runnable2 = this.a.v;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
