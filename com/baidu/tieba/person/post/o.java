package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ k bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bHG = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.bHG.bHy;
        gVar.ed(true);
    }
}
