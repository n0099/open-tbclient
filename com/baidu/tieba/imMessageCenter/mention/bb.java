package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ az duF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.duF = azVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        if (i != 0) {
            pVar = this.duF.duz;
            if (pVar != null) {
                pVar2 = this.duF.duz;
                pVar2.DO();
                if (this.duF.dtC != null) {
                    this.duF.dtC.azG();
                }
            }
        }
    }
}
