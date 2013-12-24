package com.baidu.tieba.mention;

import android.app.Activity;
import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.a = jVar;
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
        handler = this.a.r;
        runnable = this.a.s;
        handler.removeCallbacks(runnable);
        handler2 = this.a.r;
        runnable2 = this.a.s;
        handler2.postDelayed(runnable2, 300L);
        bdListView = this.a.e;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.a.e;
            if (i2 < bdListView2.getAdapter().getCount()) {
                rVar = this.a.p;
                if (rVar == null) {
                    j jVar = this.a;
                    activity = this.a.c;
                    jVar.p = new com.baidu.tieba.view.r(activity);
                    rVar2 = this.a.p;
                    rVar2.setHeightDip(30);
                    bdListView3 = this.a.e;
                    rVar3 = this.a.p;
                    bdListView3.addFooterView(rVar3);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
