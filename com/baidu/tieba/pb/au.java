package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class au implements com.baidu.tieba.model.br {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.model.br
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.ax axVar) {
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
        this.a.w();
        crVar = this.a.A;
        crVar.e(str);
        crVar2 = this.a.A;
        crVar2.A();
        if (!z) {
            if (i == 4 || i == 28) {
                bmVar3 = this.a.u;
                if (bmVar3.i()) {
                    this.a.closeActivity();
                }
            }
        } else if (axVar != null) {
            bpVar = this.a.y;
            String c = bpVar.c();
            if (c != null) {
                bpVar2 = this.a.y;
                if ("mention".equals(bpVar2.c()) || c.equals("person_post_reply")) {
                    str2 = this.a.E;
                    if (str2 != null) {
                        crVar4 = this.a.A;
                        bmVar2 = this.a.u;
                        int l = bmVar2.l().l();
                        str3 = this.a.E;
                        boolean z2 = axVar.b() > 1;
                        bpVar3 = this.a.y;
                        crVar4.a(axVar, l, str3, z2, bpVar3.g() == 1);
                        i2 = axVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.a.m = i2.getVoice_message();
                            if (axVar.h() != null) {
                                this.a.a(axVar.h().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            crVar3 = this.a.A;
            bmVar = this.a.u;
            crVar3.a(axVar, bmVar.l().l());
            i2 = axVar.i();
            if (i2 == null) {
            }
        }
    }
}
