package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements com.baidu.tieba.b.c {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // com.baidu.tieba.b.c
    public void Hj() {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.bEB.mListView;
        if (bdListView != null) {
            bdListView2 = this.bEB.mListView;
            bdListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.b.c
    public void Hi() {
        PbActivity pbActivity;
        pbActivity = this.bEB.bCF;
        pbActivity.Gd();
    }
}
