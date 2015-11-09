package com.baidu.tieba.pb.pb.sub;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        v vVar;
        com.baidu.tbadk.editortools.c.p pVar;
        if (i == 2 || i == 1) {
            vVar = this.cnS.cnJ;
            vVar.aho();
        }
        pVar = this.cnS.cbv;
        pVar.BC();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
