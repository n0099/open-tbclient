package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.f1637a = personListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1637a.g;
        runnable = this.f1637a.p;
        handler.removeCallbacks(runnable);
        handler2 = this.f1637a.g;
        runnable2 = this.f1637a.p;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
