package com.baidu.tieba.person;
/* loaded from: classes.dex */
class p implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(g gVar) {
        this.bHc = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.bHc.hasMore) {
            this.bHc.bGQ.EF();
            this.bHc.hn(this.bHc.bGU);
            return;
        }
        this.bHc.bGQ.Fi();
    }
}
