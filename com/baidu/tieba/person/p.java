package com.baidu.tieba.person;
/* loaded from: classes.dex */
class p implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(g gVar) {
        this.bHb = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.bHb.hasMore) {
            this.bHb.bGP.Ez();
            this.bHb.hn(this.bHb.bGT);
            return;
        }
        this.bHb.bGP.hL(this.bHb.getString(com.baidu.tieba.z.person_post_bar_no_more));
    }
}
