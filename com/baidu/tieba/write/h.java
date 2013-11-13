package com.baidu.tieba.write;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.f2708a = atListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f2708a.e;
        runnable = this.f2708a.s;
        handler.removeCallbacks(runnable);
        handler2 = this.f2708a.e;
        runnable2 = this.f2708a.s;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
