package com.baidu.tieba.person;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(aj ajVar) {
        this.bQe = ajVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        at atVar;
        z = this.bQe.bQb;
        if (!z) {
            this.bQe.bQa = false;
            aj ajVar = this.bQe;
            atVar = this.bQe.bPW;
            ajVar.pageNum = atVar.getData().XE().qj() + 1;
            this.bQe.bQb = true;
            this.bQe.adc();
        }
    }
}
