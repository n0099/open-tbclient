package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class be implements BdListView.e {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar) {
        this.cYT = axVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        boolean z;
        bg bgVar;
        z = this.cYT.cYP;
        if (!z) {
            this.cYT.cYO = false;
            ax axVar = this.cYT;
            bgVar = this.cYT.cYK;
            axVar.pageNum = bgVar.getData().getPage().st() + 1;
            this.cYT.cYP = true;
            this.cYT.atQ();
        }
    }
}
