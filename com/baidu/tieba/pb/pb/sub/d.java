package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        t tVar;
        com.baidu.tbadk.editortools.c.n nVar;
        if (i == 2 || i == 1) {
            tVar = this.cmr.cmk;
            tVar.agM();
        }
        nVar = this.cmr.caJ;
        nVar.BM();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
