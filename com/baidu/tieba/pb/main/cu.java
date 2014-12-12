package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tieba.b.c {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // com.baidu.tieba.b.c
    public void GS() {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.bCR.mListView;
        if (bdListView != null) {
            bdListView2 = this.bCR.mListView;
            bdListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.b.c
    public void GR() {
        PbActivity pbActivity;
        pbActivity = this.bCR.bAW;
        pbActivity.FM();
    }
}
