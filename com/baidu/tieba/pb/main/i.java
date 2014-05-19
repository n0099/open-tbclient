package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class i implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        bj bjVar;
        handler = this.a.x;
        handler.removeMessages(1);
        handler2 = this.a.x;
        handler3 = this.a.x;
        handler2.sendMessageDelayed(handler3.obtainMessage(1), 90L);
        if (i == 2 || i == 1) {
            bjVar = this.a.E;
            bjVar.ac();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
