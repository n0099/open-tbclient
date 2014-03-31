package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class i implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.a.w;
        handler.removeMessages(1);
        handler2 = this.a.w;
        handler3 = this.a.w;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
