package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ k caU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.caU = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.caU instanceof j) {
            this.caU.caK.ady().Hg();
        } else {
            this.caU.caK.adx().Hg();
        }
    }
}
