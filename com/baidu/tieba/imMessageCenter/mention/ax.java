package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ax implements AbsListView.OnScrollListener {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.dni = avVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        if (i != 0) {
            nVar = this.dni.dnc;
            if (nVar != null) {
                nVar2 = this.dni.dnc;
                nVar2.Dk();
            }
        }
    }
}
