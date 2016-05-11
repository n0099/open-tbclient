package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bf implements BdListView.e {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ay ayVar) {
        this.dwQ = ayVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        boolean z;
        bh bhVar;
        z = this.dwQ.dwM;
        if (!z) {
            this.dwQ.dwL = false;
            ay ayVar = this.dwQ;
            bhVar = this.dwQ.dwI;
            ayVar.pageNum = bhVar.getData().getPage().pI() + 1;
            this.dwQ.dwM = true;
            this.dwQ.atN();
        }
    }
}
