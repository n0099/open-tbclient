package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bd implements BdListView.e {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(aw awVar) {
        this.cqq = awVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bf bfVar;
        z = this.cqq.cqm;
        if (!z) {
            this.cqq.cql = false;
            aw awVar = this.cqq;
            bfVar = this.cqq.cqh;
            awVar.pageNum = bfVar.getData().getPage().rJ() + 1;
            this.cqq.cqm = true;
            this.cqq.aiH();
        }
    }
}
