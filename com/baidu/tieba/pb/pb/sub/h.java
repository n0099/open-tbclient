package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ag agVar;
        com.baidu.tbadk.editortools.e.p pVar;
        if (i == 2 || i == 1) {
            agVar = this.exF.exu;
            agVar.aBc();
        }
        pVar = this.exF.duz;
        pVar.DO();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ag agVar;
        agVar = this.exF.exu;
        agVar.aRp();
    }
}
