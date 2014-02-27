package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class ba implements dy {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.dy
    public final void a() {
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.be beVar2;
        cu cuVar;
        beVar = this.a.A;
        if (beVar != null) {
            beVar2 = this.a.A;
            if (beVar2.h()) {
                cuVar = this.a.C;
                cuVar.v();
            }
        }
    }
}
