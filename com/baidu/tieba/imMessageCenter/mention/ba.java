package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements AbsListView.OnScrollListener {
    final /* synthetic */ ay cyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ay ayVar) {
        this.cyj = ayVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        if (i != 0) {
            pVar = this.cyj.cye;
            if (pVar != null) {
                pVar2 = this.cyj.cye;
                pVar2.Es();
                if (this.cyj.cxj != null) {
                    this.cyj.cxj.aln();
                }
            }
        }
    }
}
