package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class ao implements AbsListView.OnScrollListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        cu cuVar;
        Handler handler5;
        handler = this.a.v;
        if (handler != null) {
            handler5 = this.a.v;
            handler5.removeMessages(0);
        }
        this.a.N = i;
        if (i == 0 || i == 1) {
            handler2 = this.a.v;
            if (handler2 != null) {
                handler3 = this.a.v;
                handler4 = this.a.v;
                handler3.sendMessageDelayed(handler4.obtainMessage(0), 300L);
            }
        }
        if (i == 2 || i == 1) {
            cuVar = this.a.C;
            cuVar.R();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
