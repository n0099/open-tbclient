package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bc implements BdListView.e {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(av avVar) {
        this.ckB = avVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        be beVar;
        z = this.ckB.ckx;
        if (!z) {
            this.ckB.ckw = false;
            av avVar = this.ckB;
            beVar = this.ckB.cks;
            avVar.pageNum = beVar.getData().getPage().rO() + 1;
            this.ckB.ckx = true;
            this.ckB.agH();
        }
    }
}
