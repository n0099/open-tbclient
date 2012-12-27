package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AbsListView.OnScrollListener {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        m mVar;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.z;
        runnable = this.a.D;
        handler.removeCallbacks(runnable);
        mVar = this.a.g;
        if (mVar.b() != null) {
            handler2 = this.a.z;
            runnable2 = this.a.D;
            handler2.postDelayed(runnable2, 300L);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.a.l();
    }
}
