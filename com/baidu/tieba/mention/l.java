package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ k cai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cai = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.cai instanceof j) {
            this.cai.bZY.adh().Hn();
        } else {
            this.cai.bZY.adg().Hn();
        }
    }
}
