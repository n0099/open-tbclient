package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonLbsActivity f1340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonLbsActivity personLbsActivity) {
        this.f1340a = personLbsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1340a.u;
        runnable = this.f1340a.v;
        handler.removeCallbacks(runnable);
        handler2 = this.f1340a.u;
        runnable2 = this.f1340a.v;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
