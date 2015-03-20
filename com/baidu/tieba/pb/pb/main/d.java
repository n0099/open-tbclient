package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ci ciVar;
        ci ciVar2;
        if (i == 2 || i == 1) {
            ciVar = this.bIv.bHY;
            ciVar.abo();
        }
        ciVar2 = this.bIv.bHY;
        ciVar2.aaz().acm();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
