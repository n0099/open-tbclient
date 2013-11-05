package com.baidu.tieba.mention;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f1869a = jVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1869a.q;
        runnable = this.f1869a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f1869a.q;
        runnable2 = this.f1869a.r;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
