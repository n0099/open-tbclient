package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bb implements db {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.f2065a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.db
    public void a(com.baidu.tieba.data.bb bbVar) {
        com.baidu.tieba.model.bo boVar;
        com.baidu.tieba.model.bo boVar2;
        bt btVar;
        boVar = this.f2065a.s;
        if (boVar != null) {
            boVar2 = this.f2065a.s;
            if (boVar2.e()) {
                btVar = this.f2065a.u;
                btVar.D();
            }
        }
    }
}
