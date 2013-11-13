package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class au implements com.baidu.tieba.model.br {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f2078a = newPbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.model.br
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.aw awVar) {
        cp cpVar;
        cp cpVar2;
        com.baidu.tieba.model.bp bpVar;
        cp cpVar3;
        com.baidu.tieba.model.bm bmVar;
        AntiData i2;
        String str2;
        cp cpVar4;
        com.baidu.tieba.model.bm bmVar2;
        String str3;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bm bmVar3;
        this.f2078a.t();
        cpVar = this.f2078a.y;
        cpVar.e(str);
        cpVar2 = this.f2078a.y;
        cpVar2.z();
        if (!z) {
            if (i == 4 || i == 28) {
                bmVar3 = this.f2078a.s;
                if (bmVar3.i()) {
                    this.f2078a.closeActivity();
                }
            }
        } else if (awVar != null) {
            bpVar = this.f2078a.w;
            if ("mention".equals(bpVar.c())) {
                str2 = this.f2078a.D;
                if (str2 != null) {
                    cpVar4 = this.f2078a.y;
                    bmVar2 = this.f2078a.s;
                    int l = bmVar2.l().l();
                    str3 = this.f2078a.D;
                    boolean z2 = awVar.b() > 1;
                    bpVar2 = this.f2078a.w;
                    cpVar4.a(awVar, l, str3, z2, bpVar2.g() == 1);
                    i2 = awVar.i();
                    if (i2 == null) {
                        Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                        this.f2078a.l = i2.getVoice_message();
                        this.f2078a.a(valueOf);
                        return;
                    }
                    return;
                }
            }
            cpVar3 = this.f2078a.y;
            bmVar = this.f2078a.s;
            cpVar3.a(awVar, bmVar.l().l());
            i2 = awVar.i();
            if (i2 == null) {
            }
        }
    }
}
