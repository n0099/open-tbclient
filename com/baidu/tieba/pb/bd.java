package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bd implements AbsListView.OnScrollListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        bk bkVar;
        handler = this.a.h;
        handler.removeMessages(0);
        handler2 = this.a.h;
        handler3 = this.a.h;
        handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
        if (i == 2 || i == 1) {
            bkVar = this.a.o;
            bkVar.O();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
