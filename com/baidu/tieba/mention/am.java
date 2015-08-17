package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AbsListView.OnScrollListener {
    final /* synthetic */ ak bWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.bWv = akVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        if (i != 0) {
            nVar = this.bWv.bWp;
            if (nVar != null) {
                nVar2 = this.bWv.bWp;
                nVar2.BL();
            }
        }
    }
}
