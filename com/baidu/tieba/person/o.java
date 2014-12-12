package com.baidu.tieba.person;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.bFr = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aag;
        aag = this.bFr.aag();
        if (aag != null) {
            this.bFr.bFj = 1;
            this.bFr.IX();
        }
    }
}
