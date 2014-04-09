package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class h implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        bm bmVar;
        bm bmVar2;
        Handler handler5;
        handler = this.a.w;
        if (handler != null) {
            handler5 = this.a.w;
            handler5.removeMessages(0);
        }
        this.a.V = i;
        if (i == 0 || i == 1) {
            handler2 = this.a.w;
            if (handler2 != null) {
                handler3 = this.a.w;
                handler4 = this.a.w;
                handler3.sendMessageDelayed(handler4.obtainMessage(0), 300L);
            }
        }
        if (i == 2 || i == 1) {
            bmVar = this.a.D;
            bmVar.ab();
            bmVar2 = this.a.D;
            bmVar2.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
