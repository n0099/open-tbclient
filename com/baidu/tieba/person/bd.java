package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bd implements BdListView.e {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(aw awVar) {
        this.cqf = awVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bf bfVar;
        z = this.cqf.cqb;
        if (!z) {
            this.cqf.cqa = false;
            aw awVar = this.cqf;
            bfVar = this.cqf.cpW;
            awVar.pageNum = bfVar.getData().getPage().rJ() + 1;
            this.cqf.cqb = true;
            this.cqf.aiH();
        }
    }
}
