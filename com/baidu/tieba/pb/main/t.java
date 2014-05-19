package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements cp {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cp
    public void a(com.baidu.tieba.data.ao aoVar) {
        com.baidu.tieba.pb.sub.f fVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bj bjVar;
        fVar = this.a.C;
        if (fVar != null) {
            fVar2 = this.a.C;
            if (fVar2.h()) {
                bjVar = this.a.E;
                bjVar.B();
            }
        }
    }
}
