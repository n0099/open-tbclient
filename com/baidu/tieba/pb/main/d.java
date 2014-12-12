package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bz bzVar;
        if (i == 2 || i == 1) {
            bzVar = this.bzj.byO;
            bzVar.YE();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
