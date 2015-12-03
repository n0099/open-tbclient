package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements AbsListView.OnScrollListener {
    final /* synthetic */ aw cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar) {
        this.cfd = awVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        if (i != 0) {
            pVar = this.cfd.ceY;
            if (pVar != null) {
                pVar2 = this.cfd.ceY;
                pVar2.CD();
                if (this.cfd.ceg != null) {
                    this.cfd.ceg.adC();
                }
            }
        }
    }
}
