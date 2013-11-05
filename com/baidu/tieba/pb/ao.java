package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class ao implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2051a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f2051a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        bt btVar;
        handler = this.f2051a.n;
        handler.removeMessages(0);
        handler2 = this.f2051a.n;
        handler3 = this.f2051a.n;
        handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
        if (i == 2 || i == 1) {
            btVar = this.f2051a.u;
            btVar.ac();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
