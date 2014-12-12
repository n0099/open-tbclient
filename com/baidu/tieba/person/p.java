package com.baidu.tieba.person;
/* loaded from: classes.dex */
class p implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(g gVar) {
        this.bFr = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.bFr.hasMore) {
            this.bFr.bFf.Eg();
            this.bFr.he(this.bFr.bFj);
            return;
        }
        this.bFr.bFf.EJ();
    }
}
