package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class e implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        cj cjVar;
        cj cjVar2;
        com.baidu.tieba.pb.pb.sub.e eVar;
        cjVar = this.bIJ.bIl;
        if (cjVar.abD() && com.baidu.adp.lib.util.n.isNetOk()) {
            eVar = this.bIJ.bIj;
            eVar.AZ();
            return;
        }
        cjVar2 = this.bIJ.bIl;
        cjVar2.abk();
    }
}
