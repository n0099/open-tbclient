package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bd implements com.baidu.tieba.model.bd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.f1470a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.as asVar, String str) {
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.model.av avVar;
        bn bnVar3;
        com.baidu.tieba.model.bc bcVar;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        com.baidu.tieba.model.bc bcVar2;
        if (z && asVar != null) {
            avVar = this.f1470a.k;
            avVar.a(asVar.f());
            bnVar3 = this.f1470a.p;
            bcVar = this.f1470a.j;
            bnVar3.a(asVar, i2, i3, bcVar.c());
            bnVar4 = this.f1470a.p;
            bnVar4.a(asVar, false);
            bnVar5 = this.f1470a.p;
            bnVar5.R();
            bnVar6 = this.f1470a.p;
            bcVar2 = this.f1470a.j;
            bnVar6.c(bcVar2.b());
        } else if (str != null) {
            bnVar = this.f1470a.p;
            bnVar.p();
            bnVar2 = this.f1470a.p;
            bnVar2.d(str);
            if (i == 4 || i == 28) {
                this.f1470a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.model.bd
    public void a(com.baidu.tieba.data.as asVar) {
        bn bnVar;
        bnVar = this.f1470a.p;
        bnVar.a(asVar);
    }
}
