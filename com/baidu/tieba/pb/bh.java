package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bh implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewPbActivity newPbActivity) {
        this.f1511a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        bo boVar;
        handler = this.f1511a.j;
        handler.removeMessages(0);
        handler2 = this.f1511a.j;
        handler3 = this.f1511a.j;
        handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
        if (i == 2 || i == 1) {
            boVar = this.f1511a.q;
            boVar.P();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
