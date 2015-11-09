package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bd implements BdListView.e {
    final /* synthetic */ aw crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(aw awVar) {
        this.crM = awVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bf bfVar;
        z = this.crM.crI;
        if (!z) {
            this.crM.crH = false;
            aw awVar = this.crM;
            bfVar = this.crM.crD;
            awVar.pageNum = bfVar.getData().getPage().rI() + 1;
            this.crM.crI = true;
            this.crM.ajj();
        }
    }
}
