package com.baidu.tieba.person;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(aj ajVar) {
        this.bQu = ajVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        at atVar;
        z = this.bQu.bQr;
        if (!z) {
            this.bQu.bQq = false;
            aj ajVar = this.bQu;
            atVar = this.bQu.bQm;
            ajVar.pageNum = atVar.getData().XQ().qj() + 1;
            this.bQu.bQr = true;
            this.bQu.adr();
        }
    }
}
