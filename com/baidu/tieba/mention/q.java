package com.baidu.tieba.mention;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.a = mVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        handler = this.a.p;
        runnable = this.a.q;
        handler.removeCallbacks(runnable);
        handler2 = this.a.p;
        runnable2 = this.a.q;
        handler2.postDelayed(runnable2, 90L);
        bdListView = this.a.e;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.a.e;
            bdListView2.getAdapter().getCount();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
