package com.baidu.tieba.pb.main;

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
        bq bqVar;
        if (i == 2 || i == 1) {
            bqVar = this.a.D;
            bqVar.ac();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
