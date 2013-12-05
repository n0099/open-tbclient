package com.baidu.tieba.mention;

import android.app.Activity;
import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1960a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f1960a = jVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        com.baidu.tieba.view.r rVar;
        Activity activity;
        com.baidu.tieba.view.r rVar2;
        BdListView bdListView3;
        com.baidu.tieba.view.r rVar3;
        handler = this.f1960a.r;
        runnable = this.f1960a.s;
        handler.removeCallbacks(runnable);
        handler2 = this.f1960a.r;
        runnable2 = this.f1960a.s;
        handler2.postDelayed(runnable2, 300L);
        bdListView = this.f1960a.e;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.f1960a.e;
            if (i2 < bdListView2.getAdapter().getCount()) {
                rVar = this.f1960a.p;
                if (rVar == null) {
                    j jVar = this.f1960a;
                    activity = this.f1960a.c;
                    jVar.p = new com.baidu.tieba.view.r(activity);
                    rVar2 = this.f1960a.p;
                    rVar2.setHeightDip(30);
                    bdListView3 = this.f1960a.e;
                    rVar3 = this.f1960a.p;
                    bdListView3.addFooterView(rVar3);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
