package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        w wVar;
        com.baidu.tbadk.editortools.d.p pVar;
        if (i == 2 || i == 1) {
            wVar = this.cHd.cGU;
            wVar.alO();
        }
        pVar = this.cHd.ceY;
        pVar.CD();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
