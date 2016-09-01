package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ag agVar;
        com.baidu.tbadk.editortools.d.p pVar;
        if (i == 2 || i == 1) {
            agVar = this.evy.evn;
            agVar.aAE();
        }
        pVar = this.evy.dtc;
        pVar.DO();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ag agVar;
        agVar = this.evy.evn;
        agVar.aQH();
    }
}
