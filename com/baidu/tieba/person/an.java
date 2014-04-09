package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an implements AbsListView.OnScrollListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.a = akVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
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
            this.a.d();
        }
    }
}
