package com.baidu.tieba.person;
/* loaded from: classes.dex */
class at implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(am amVar) {
        this.bGm = amVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        boolean z;
        aw awVar;
        z = this.bGm.bGj;
        if (!z) {
            this.bGm.bGi = false;
            am amVar = this.bGm;
            awVar = this.bGm.bGe;
            amVar.pageNum = awVar.getData().mY().mU() + 1;
            this.bGm.bGj = true;
            this.bGm.aat();
        }
    }
}
