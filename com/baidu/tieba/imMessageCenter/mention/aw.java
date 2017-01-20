package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements AbsListView.OnScrollListener {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.dky = auVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        if (i != 0) {
            nVar = this.dky.dkr;
            if (nVar != null) {
                nVar2 = this.dky.dkr;
                nVar2.Dv();
            }
        }
    }
}
