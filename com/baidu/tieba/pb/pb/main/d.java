package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        cj cjVar;
        cj cjVar2;
        if (i == 2 || i == 1) {
            cjVar = this.bIJ.bIl;
            cjVar.abC();
        }
        cjVar2 = this.bIJ.bIl;
        cjVar2.aaM().acB();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
