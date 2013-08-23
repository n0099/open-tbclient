package com.baidu.tieba.pb;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class be implements com.baidu.tieba.model.bc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewPbActivity newPbActivity) {
        this.f1508a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ao aoVar, String str) {
        bo boVar;
        bo boVar2;
        com.baidu.tieba.model.au auVar;
        bo boVar3;
        com.baidu.tieba.model.bb bbVar;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        com.baidu.tieba.model.bb bbVar2;
        boVar = this.f1508a.q;
        boVar.q();
        if (z && aoVar != null) {
            auVar = this.f1508a.l;
            auVar.a(aoVar.g());
            boVar3 = this.f1508a.q;
            bbVar = this.f1508a.k;
            boVar3.a(aoVar, i2, i3, bbVar.c());
            boVar4 = this.f1508a.q;
            boVar4.a(aoVar, false);
            boVar5 = this.f1508a.q;
            boVar5.S();
            boVar6 = this.f1508a.q;
            bbVar2 = this.f1508a.k;
            boVar6.c(bbVar2.b());
        } else if (str != null) {
            if (NetWorkCore.b(this.f1508a) != NetWorkCore.NetworkState.UNAVAIL) {
                boVar2 = this.f1508a.q;
                boVar2.d(str);
            } else {
                this.f1508a.k();
            }
            if (i == 4 || i == 28) {
                this.f1508a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.model.bc
    public void a(com.baidu.tieba.data.ao aoVar) {
        bo boVar;
        boVar = this.f1508a.q;
        boVar.a(aoVar);
    }
}
