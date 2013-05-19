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
        bl blVar;
        Handler handler4;
        com.baidu.tieba.c.au auVar;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        handler = this.a.h;
        handler.removeMessages(0);
        handler2 = this.a.h;
        handler3 = this.a.h;
        handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
        if (i == 2 || i == 1) {
            blVar = this.a.o;
            blVar.N();
            handler4 = this.a.h;
            handler4.removeMessages(2);
        }
        if (i == 0) {
            auVar = this.a.i;
            if (auVar.v()) {
                handler5 = this.a.h;
                handler5.removeMessages(2);
                handler6 = this.a.h;
                handler7 = this.a.h;
                handler6.sendMessageDelayed(handler7.obtainMessage(2), 2000L);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
