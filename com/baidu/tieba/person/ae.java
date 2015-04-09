package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ae implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(v vVar) {
        this.bPV = vVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        String str;
        if (this.bPV.hasMore) {
            this.bPV.bPI.IL();
            this.bPV.hB(this.bPV.bPM);
            return;
        }
        com.baidu.tieba.person.post.z zVar = this.bPV.bPI;
        str = this.bPV.bPQ;
        zVar.ia(str);
    }
}
