package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ k bVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bVQ = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.bVQ instanceof j) {
            this.bVQ.bVG.abK().HF();
        } else {
            this.bVQ.bVG.abJ().HF();
        }
    }
}
