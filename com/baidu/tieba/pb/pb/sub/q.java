package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ao aoVar;
        com.baidu.tbadk.editortools.pb.n nVar;
        if (i == 2 || i == 1) {
            aoVar = this.euQ.euB;
            aoVar.awO();
        }
        nVar = this.euQ.dmL;
        nVar.DO();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ao aoVar;
        aoVar = this.euQ.euB;
        aoVar.aOA();
    }
}
