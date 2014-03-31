package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class t implements cr {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cr
    public final void a() {
        com.baidu.tieba.pb.sub.f fVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bk bkVar;
        fVar = this.a.B;
        if (fVar != null) {
            fVar2 = this.a.B;
            if (fVar2.h()) {
                bkVar = this.a.D;
                bkVar.B();
            }
        }
    }
}
