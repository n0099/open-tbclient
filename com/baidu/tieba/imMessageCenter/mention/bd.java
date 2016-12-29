package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements AbsListView.OnScrollListener {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        if (i != 0) {
            pVar = this.ddm.ddg;
            if (pVar != null) {
                pVar2 = this.ddm.ddg;
                pVar2.DA();
            }
        }
    }
}
