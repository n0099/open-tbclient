package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements cv {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cv
    public void a(com.baidu.tieba.data.at atVar) {
        com.baidu.tieba.pb.sub.f fVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bt btVar;
        fVar = this.a.B;
        if (fVar != null) {
            fVar2 = this.a.B;
            if (fVar2.i()) {
                btVar = this.a.D;
                btVar.C();
            }
        }
    }
}
