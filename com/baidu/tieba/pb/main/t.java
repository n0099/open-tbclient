package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class t implements ct {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ct
    public final void a() {
        com.baidu.tieba.pb.sub.f fVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bm bmVar;
        fVar = this.a.B;
        if (fVar != null) {
            fVar2 = this.a.B;
            if (fVar2.h()) {
                bmVar = this.a.D;
                bmVar.B();
            }
        }
    }
}
