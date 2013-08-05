package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class at implements ct {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f1461a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.ct
    public void a(com.baidu.tieba.data.bh bhVar) {
        com.baidu.tieba.model.bf bfVar;
        com.baidu.tieba.model.bf bfVar2;
        bn bnVar;
        bfVar = this.f1461a.n;
        if (bfVar != null) {
            bfVar2 = this.f1461a.n;
            if (bfVar2.e()) {
                bnVar = this.f1461a.p;
                bnVar.s();
            }
        }
    }
}
