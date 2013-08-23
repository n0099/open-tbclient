package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bj implements com.baidu.tieba.model.bg {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.f1513a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bg
    public void a(boolean z, int i, String str, com.baidu.tieba.data.bd bdVar) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        boVar = this.f1513a.q;
        boVar.d(str);
        boVar2 = this.f1513a.q;
        boVar2.w();
        if (!z) {
            if (i == 4 || i == 28) {
                bbVar2 = this.f1513a.k;
                if (bbVar2.h()) {
                    this.f1513a.f();
                }
            }
        } else if (bdVar != null) {
            boVar3 = this.f1513a.q;
            bbVar = this.f1513a.k;
            boVar3.a(bdVar, bbVar.k().j());
        }
    }
}
