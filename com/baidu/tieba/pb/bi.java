package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bi implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(NewPbActivity newPbActivity) {
        this.f1512a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f1512a.j;
        handler.removeMessages(1);
        handler2 = this.f1512a.j;
        handler3 = this.f1512a.j;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
