package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements AbsListView.OnScrollListener {
    final /* synthetic */ ax cnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.cnH = axVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        if (i != 0) {
            pVar = this.cnH.cnC;
            if (pVar != null) {
                pVar2 = this.cnH.cnC;
                pVar2.DI();
                if (this.cnH.cmH != null) {
                    this.cnH.cmH.ahT();
                }
            }
        }
    }
}
