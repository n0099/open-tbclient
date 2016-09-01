package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ az dti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.dti = azVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        if (i != 0) {
            pVar = this.dti.dtc;
            if (pVar != null) {
                pVar2 = this.dti.dtc;
                pVar2.DO();
                if (this.dti.dsf != null) {
                    this.dti.dsf.azi();
                }
            }
        }
    }
}
