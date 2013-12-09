package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class au implements com.baidu.tieba.model.br {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f2169a = newPbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.model.br
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.av avVar) {
        cr crVar;
        cr crVar2;
        com.baidu.tieba.model.bp bpVar;
        cr crVar3;
        com.baidu.tieba.model.bm bmVar;
        AntiData i2;
        com.baidu.tieba.model.bp bpVar2;
        String str2;
        cr crVar4;
        com.baidu.tieba.model.bm bmVar2;
        String str3;
        com.baidu.tieba.model.bp bpVar3;
        com.baidu.tieba.model.bm bmVar3;
        this.f2169a.u();
        crVar = this.f2169a.y;
        crVar.e(str);
        crVar2 = this.f2169a.y;
        crVar2.z();
        if (!z) {
            if (i == 4 || i == 28) {
                bmVar3 = this.f2169a.s;
                if (bmVar3.i()) {
                    this.f2169a.closeActivity();
                }
            }
        } else if (avVar != null) {
            bpVar = this.f2169a.w;
            String c = bpVar.c();
            if (c != null) {
                bpVar2 = this.f2169a.w;
                if ("mention".equals(bpVar2.c()) || c.equals("person_post_reply")) {
                    str2 = this.f2169a.D;
                    if (str2 != null) {
                        crVar4 = this.f2169a.y;
                        bmVar2 = this.f2169a.s;
                        int l = bmVar2.l().l();
                        str3 = this.f2169a.D;
                        boolean z2 = avVar.b() > 1;
                        bpVar3 = this.f2169a.w;
                        crVar4.a(avVar, l, str3, z2, bpVar3.g() == 1);
                        i2 = avVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.f2169a.l = i2.getVoice_message();
                            this.f2169a.a(valueOf);
                            return;
                        }
                        return;
                    }
                }
            }
            crVar3 = this.f2169a.y;
            bmVar = this.f2169a.s;
            crVar3.a(avVar, bmVar.l().l());
            i2 = avVar.i();
            if (i2 == null) {
            }
        }
    }
}
