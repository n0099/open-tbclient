package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ TopRecActivity ccL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.ccL = topRecActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        j jVar;
        jVar = this.ccL.ccD;
        jVar.LoadData();
    }
}
