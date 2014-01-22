package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class as implements AbsListView.OnScrollListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        cr crVar;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        handler = this.a.t;
        if (handler != null) {
            handler5 = this.a.t;
            handler5.removeMessages(0);
        }
        this.a.L = i;
        if (i == 0) {
            handler2 = this.a.t;
            if (handler2 != null) {
                handler3 = this.a.t;
                handler4 = this.a.t;
                handler3.sendMessageDelayed(handler4.obtainMessage(0), 300L);
            }
        }
        if (i == 2 || i == 1) {
            crVar = this.a.A;
            crVar.Z();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
