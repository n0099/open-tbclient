package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ao aoVar;
        com.baidu.tbadk.editortools.pb.n nVar;
        if (i == 2 || i == 1) {
            aoVar = this.eye.exP;
            aoVar.avy();
        }
        nVar = this.eye.dnc;
        nVar.Dk();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ao aoVar;
        aoVar = this.eye.exP;
        aoVar.aOj();
    }
}
