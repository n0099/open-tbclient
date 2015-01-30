package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements com.baidu.tieba.b.c {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // com.baidu.tieba.b.c
    public void Hp() {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.bEC.mListView;
        if (bdListView != null) {
            bdListView2 = this.bEC.mListView;
            bdListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.b.c
    public void Ho() {
        PbActivity pbActivity;
        pbActivity = this.bEC.bCG;
        pbActivity.Gj();
    }
}
