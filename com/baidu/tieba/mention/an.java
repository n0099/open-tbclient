package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements AbsListView.OnScrollListener {
    final /* synthetic */ al caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.caZ = alVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        if (i != 0) {
            nVar = this.caZ.caU;
            if (nVar != null) {
                nVar2 = this.caZ.caU;
                nVar2.BJ();
            }
        }
    }
}
