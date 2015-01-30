package com.baidu.tieba.person;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.bHc = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aaL;
        aaL = this.bHc.aaL();
        if (aaL != null) {
            this.bHc.bGU = 1;
            this.bHc.Jv();
        }
    }
}
