package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bj implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bc bcVar) {
        this.bSZ = bcVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        bm bmVar;
        z = this.bSZ.bSW;
        if (!z) {
            this.bSZ.bSV = false;
            bc bcVar = this.bSZ;
            bmVar = this.bSZ.bSR;
            bcVar.pageNum = bmVar.getData().Zp().qP() + 1;
            this.bSZ.bSW = true;
            this.bSZ.aez();
        }
    }
}
