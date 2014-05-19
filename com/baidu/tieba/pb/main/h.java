package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class h implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        bj bjVar;
        bj bjVar2;
        Handler handler5;
        handler = this.a.x;
        if (handler != null) {
            handler5 = this.a.x;
            handler5.removeMessages(0);
        }
        this.a.W = i;
        if (i == 0 || i == 1) {
            handler2 = this.a.x;
            if (handler2 != null) {
                handler3 = this.a.x;
                handler4 = this.a.x;
                handler3.sendMessageDelayed(handler4.obtainMessage(0), 90L);
            }
        }
        if (i == 2 || i == 1) {
            bjVar = this.a.E;
            bjVar.ac();
            bjVar2 = this.a.E;
            bjVar2.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
