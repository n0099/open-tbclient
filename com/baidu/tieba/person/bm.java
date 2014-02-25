package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements AbsListView.OnScrollListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.f;
        if (handler != null) {
            handler4 = this.a.f;
            runnable2 = this.a.k;
            handler4.removeCallbacks(runnable2);
        }
        if (i == 0) {
            handler2 = this.a.f;
            if (handler2 != null) {
                handler3 = this.a.f;
                runnable = this.a.k;
                handler3.postDelayed(runnable, 300L);
            }
        }
    }
}
