package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AbsListView.OnScrollListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        handler = this.a.f;
        if (handler != null) {
            handler2 = this.a.f;
            runnable = this.a.k;
            handler2.removeCallbacks(runnable);
        }
        if (i == 0) {
            this.a.g();
        }
    }
}
