package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bv bvVar;
        if (i == 2 || i == 1) {
            bvVar = this.bvu.buZ;
            bvVar.Yg();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
