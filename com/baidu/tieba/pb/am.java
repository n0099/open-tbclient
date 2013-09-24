package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.bi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f1532a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bi
    public void a(boolean z, int i, String str, com.baidu.tieba.data.bd bdVar) {
        br brVar;
        br brVar2;
        br brVar3;
        com.baidu.tieba.model.bd bdVar2;
        com.baidu.tieba.model.bd bdVar3;
        Boolean bool = null;
        this.f1532a.v();
        brVar = this.f1532a.t;
        brVar.d(str);
        brVar2 = this.f1532a.t;
        brVar2.G();
        if (!z) {
            if (i == 4 || i == 28) {
                bdVar3 = this.f1532a.n;
                if (bdVar3.h()) {
                    this.f1532a.g();
                }
            }
        } else if (bdVar != null) {
            brVar3 = this.f1532a.t;
            bdVar2 = this.f1532a.n;
            brVar3.a(bdVar, bdVar2.k().j());
            AntiData h = bdVar.h();
            if (h != null) {
                bool = Boolean.valueOf(h.isIfvoice());
                this.f1532a.g = h.getVoice_message();
            }
        }
        this.f1532a.a(bool);
    }
}
