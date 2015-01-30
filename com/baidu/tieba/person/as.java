package com.baidu.tieba.person;
/* loaded from: classes.dex */
class as implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(al alVar) {
        this.bHX = alVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        boolean z;
        av avVar;
        z = this.bHX.bHU;
        if (!z) {
            this.bHX.bHT = false;
            al alVar = this.bHX;
            avVar = this.bHX.bHP;
            alVar.pageNum = avVar.getData().na().mW() + 1;
            this.bHX.bHU = true;
            this.bHX.aaY();
        }
    }
}
