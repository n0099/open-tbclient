package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements cw {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cw
    public void a(com.baidu.tieba.data.ap apVar) {
        com.baidu.tieba.pb.sub.f fVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bq bqVar;
        fVar = this.a.B;
        if (fVar != null) {
            fVar2 = this.a.B;
            if (fVar2.h()) {
                bqVar = this.a.D;
                bqVar.B();
            }
        }
    }
}
