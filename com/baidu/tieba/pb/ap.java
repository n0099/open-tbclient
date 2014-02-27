package com.baidu.tieba.pb;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class ap implements AbsListView.OnScrollListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.a.v;
        handler.removeMessages(1);
        handler2 = this.a.v;
        handler3 = this.a.v;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
