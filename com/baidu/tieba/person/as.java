package com.baidu.tieba.person;
/* loaded from: classes.dex */
class as implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(al alVar) {
        this.bHW = alVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        boolean z;
        av avVar;
        z = this.bHW.bHT;
        if (!z) {
            this.bHW.bHS = false;
            al alVar = this.bHW;
            avVar = this.bHW.bHO;
            alVar.pageNum = avVar.getData().mT().mP() + 1;
            this.bHW.bHT = true;
            this.bHW.aaT();
        }
    }
}
