package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class as implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.f2076a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        cp cpVar;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        handler = this.f2076a.r;
        if (handler != null) {
            handler5 = this.f2076a.r;
            handler5.removeMessages(0);
        }
        this.f2076a.J = i;
        if (i == 0) {
            handler2 = this.f2076a.r;
            if (handler2 != null) {
                handler3 = this.f2076a.r;
                handler4 = this.f2076a.r;
                handler3.sendMessageDelayed(handler4.obtainMessage(0), 300L);
            }
        }
        if (i == 2 || i == 1) {
            cpVar = this.f2076a.y;
            cpVar.Z();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
