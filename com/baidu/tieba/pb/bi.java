package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bi implements com.baidu.tieba.model.bh {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(NewPbActivity newPbActivity) {
        this.f1475a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bh
    public void a(boolean z, int i, String str, com.baidu.tieba.data.bh bhVar) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.bc bcVar;
        com.baidu.tieba.model.bc bcVar2;
        bnVar = this.f1475a.p;
        bnVar.d(str);
        bnVar2 = this.f1475a.p;
        bnVar2.v();
        if (!z) {
            if (i == 4 || i == 28) {
                bcVar2 = this.f1475a.j;
                if (bcVar2.h()) {
                    this.f1475a.f();
                }
            }
        } else if (bhVar != null) {
            bnVar3 = this.f1475a.p;
            bcVar = this.f1475a.j;
            bnVar3.a(bhVar, bcVar.j().i());
        }
    }
}
