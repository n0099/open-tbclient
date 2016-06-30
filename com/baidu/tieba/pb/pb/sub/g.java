package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        af afVar;
        com.baidu.tbadk.editortools.d.p pVar;
        if (i == 2 || i == 1) {
            afVar = this.dWP.dWE;
            afVar.avf();
        }
        pVar = this.dWP.deA;
        pVar.Cu();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        af afVar;
        afVar = this.dWP.dWE;
        afVar.aIF();
    }
}
