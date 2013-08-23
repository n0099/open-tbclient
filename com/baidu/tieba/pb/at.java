package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class at implements cu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f1496a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cu
    public void a(com.baidu.tieba.data.bd bdVar) {
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.be beVar2;
        bo boVar;
        beVar = this.f1496a.o;
        if (beVar != null) {
            beVar2 = this.f1496a.o;
            if (beVar2.e()) {
                boVar = this.f1496a.q;
                boVar.t();
            }
        }
    }
}
