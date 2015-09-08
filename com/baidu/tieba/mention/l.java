package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ k bWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bWw = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.bWw instanceof j) {
            this.bWw.bWm.abP().Ht();
        } else {
            this.bWw.bWm.abO().Ht();
        }
    }
}
