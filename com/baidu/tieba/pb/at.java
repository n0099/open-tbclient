package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class at implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f2167a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f2167a.r;
        handler.removeMessages(1);
        handler2 = this.f2167a.r;
        handler3 = this.f2167a.r;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
