package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.model.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2053a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewPbActivity newPbActivity) {
        this.f2053a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bq
    public void a(boolean z, int i, String str, com.baidu.tieba.data.bb bbVar) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.bl blVar2;
        this.f2053a.w();
        btVar = this.f2053a.u;
        btVar.d(str);
        btVar2 = this.f2053a.u;
        btVar2.G();
        if (!z) {
            if (i == 4 || i == 28) {
                blVar2 = this.f2053a.o;
                if (blVar2.h()) {
                    this.f2053a.h();
                }
            }
        } else if (bbVar != null) {
            btVar3 = this.f2053a.u;
            blVar = this.f2053a.o;
            btVar3.a(bbVar, blVar.k().j());
            AntiData h = bbVar.h();
            if (h != null) {
                Boolean valueOf = Boolean.valueOf(h.isIfvoice());
                this.f2053a.g = h.getVoice_message();
                this.f2053a.a(valueOf);
            }
        }
    }
}
