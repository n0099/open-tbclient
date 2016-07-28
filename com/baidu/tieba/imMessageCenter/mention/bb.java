package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ az dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.dhD = azVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        if (i != 0) {
            pVar = this.dhD.dhw;
            if (pVar != null) {
                pVar2 = this.dhD.dhw;
                pVar2.Ct();
                if (this.dhD.dgz != null) {
                    this.dhD.dgz.auv();
                }
            }
        }
    }
}
