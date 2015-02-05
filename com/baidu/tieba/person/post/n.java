package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class n implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ j bJr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bJr = jVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        f fVar;
        fVar = this.bJr.bJj;
        fVar.ej(true);
    }
}
