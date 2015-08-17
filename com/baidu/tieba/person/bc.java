package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bc implements BdListView.e {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(av avVar) {
        this.cjG = avVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        be beVar;
        z = this.cjG.cjC;
        if (!z) {
            this.cjG.cjB = false;
            av avVar = this.cjG;
            beVar = this.cjG.cjx;
            avVar.pageNum = beVar.getData().getPage().rR() + 1;
            this.cjG.cjC = true;
            this.cjG.agr();
        }
    }
}
