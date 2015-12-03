package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements BdListView.f {
    final /* synthetic */ v ceu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.ceu = vVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.ceu instanceof j) {
            this.ceu.ceg.adG().Iz();
        } else {
            this.ceu.ceg.adF().Iz();
        }
    }
}
