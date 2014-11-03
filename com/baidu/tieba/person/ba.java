package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ at bCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(at atVar) {
        this.bCN = atVar;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        boolean z;
        bd bdVar;
        z = this.bCN.bCJ;
        if (!z) {
            this.bCN.bCI = false;
            at atVar = this.bCN;
            bdVar = this.bCN.bCE;
            atVar.pageNum = bdVar.getData().zO().kf() + 1;
            this.bCN.bCJ = true;
            this.bCN.aac();
        }
    }
}
