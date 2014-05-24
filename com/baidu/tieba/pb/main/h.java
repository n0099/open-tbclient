package com.baidu.tieba.pb.main;

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
        bq bqVar;
        bq bqVar2;
        if (i == 2 || i == 1) {
            bqVar = this.a.D;
            bqVar.ac();
            bqVar2 = this.a.D;
            bqVar2.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
