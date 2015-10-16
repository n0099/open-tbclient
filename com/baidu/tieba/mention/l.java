package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ k cat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cat = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.cat instanceof j) {
            this.cat.caj.adh().Hn();
        } else {
            this.cat.caj.adg().Hn();
        }
    }
}
