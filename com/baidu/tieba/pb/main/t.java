package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements cu {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cu
    public void a(com.baidu.tieba.data.au auVar) {
        com.baidu.tieba.pb.sub.e eVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bs bsVar;
        eVar = this.a.C;
        if (eVar != null) {
            eVar2 = this.a.C;
            if (eVar2.j()) {
                bsVar = this.a.E;
                bsVar.C();
            }
        }
    }
}
