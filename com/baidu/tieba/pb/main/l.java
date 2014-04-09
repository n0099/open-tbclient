package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class l extends com.baidu.adp.a.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bm bmVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        bf bfVar;
        if (obj != null) {
            vVar2 = this.a.C;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bfVar = this.a.x;
                    bfVar.y();
                    PbActivity.a(this.a, (com.baidu.tieba.model.x) obj);
                    return;
                case 1:
                    this.a.D.a(r4.a, ((com.baidu.tieba.model.z) obj).b, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.a;
                    vVar3 = this.a.C;
                    PbActivity.a(pbActivity, vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    PbActivity.a(this.a, (com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        bmVar = this.a.D;
        vVar = this.a.C;
        vVar.getLoadDataMode();
        bmVar.a(false, (String) null, false);
    }
}
