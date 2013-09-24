package com.baidu.tieba.mention;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1371a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.f1371a = iVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1371a.q;
        runnable = this.f1371a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f1371a.q;
        runnable2 = this.f1371a.r;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
