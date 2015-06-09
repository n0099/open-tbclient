package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bj implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ bc bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bc bcVar) {
        this.bTa = bcVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        bm bmVar;
        z = this.bTa.bSX;
        if (!z) {
            this.bTa.bSW = false;
            bc bcVar = this.bTa;
            bmVar = this.bTa.bSS;
            bcVar.pageNum = bmVar.getData().Zq().qP() + 1;
            this.bTa.bSX = true;
            this.bTa.aeA();
        }
    }
}
