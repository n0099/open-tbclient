package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ae implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(v vVar) {
        this.bPF = vVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        String str;
        if (this.bPF.hasMore) {
            this.bPF.bPs.IF();
            this.bPF.hy(this.bPF.bPw);
            return;
        }
        com.baidu.tieba.person.post.z zVar = this.bPF.bPs;
        str = this.bPF.bPA;
        zVar.hX(str);
    }
}
