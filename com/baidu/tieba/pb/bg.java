package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bg implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f1473a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        bn bnVar;
        handler = this.f1473a.g;
        handler.removeMessages(0);
        handler2 = this.f1473a.g;
        handler3 = this.f1473a.g;
        handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
        if (i == 2 || i == 1) {
            bnVar = this.f1473a.p;
            bnVar.O();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
