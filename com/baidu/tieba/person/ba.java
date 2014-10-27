package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(at atVar) {
        this.bCz = atVar;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        boolean z;
        bd bdVar;
        z = this.bCz.bCv;
        if (!z) {
            this.bCz.bCu = false;
            at atVar = this.bCz;
            bdVar = this.bCz.bCq;
            atVar.pageNum = bdVar.getData().zM().kf() + 1;
            this.bCz.bCv = true;
            this.bCz.aaa();
        }
    }
}
