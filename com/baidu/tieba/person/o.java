package com.baidu.tieba.person;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.bHb = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aaG;
        aaG = this.bHb.aaG();
        if (aaG != null) {
            this.bHb.bGT = 1;
            this.bHb.Jq();
        }
    }
}
