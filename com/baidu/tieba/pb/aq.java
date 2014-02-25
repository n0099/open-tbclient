package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.model.bg {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.model.bg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.av avVar) {
        cu cuVar;
        cu cuVar2;
        com.baidu.tieba.model.be beVar;
        cu cuVar3;
        com.baidu.tieba.model.bb bbVar;
        AntiData i2;
        com.baidu.tieba.model.be beVar2;
        String str2;
        cu cuVar4;
        com.baidu.tieba.model.bb bbVar2;
        String str3;
        com.baidu.tieba.model.be beVar3;
        com.baidu.tieba.model.bb bbVar3;
        this.a.z();
        cuVar = this.a.C;
        cuVar.c(str);
        cuVar2 = this.a.C;
        cuVar2.B();
        if (!z) {
            if (i == 4 || i == 28) {
                bbVar3 = this.a.w;
                if (bbVar3.j()) {
                    this.a.closeActivity();
                }
            }
        } else if (avVar != null) {
            beVar = this.a.A;
            String c = beVar.c();
            if (c != null) {
                beVar2 = this.a.A;
                if ("mention".equals(beVar2.c()) || c.equals("person_post_reply")) {
                    str2 = this.a.G;
                    if (str2 != null) {
                        cuVar4 = this.a.C;
                        bbVar2 = this.a.w;
                        int l = bbVar2.m().l();
                        str3 = this.a.G;
                        boolean z2 = avVar.b() > 1;
                        beVar3 = this.a.A;
                        cuVar4.a(avVar, l, str3, z2, beVar3.g() == 1);
                        i2 = avVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.a.o = i2.getVoice_message();
                            if (avVar.h() != null) {
                                this.a.a(avVar.h().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            cuVar3 = this.a.C;
            bbVar = this.a.w;
            cuVar3.a(avVar, bbVar.m().l());
            i2 = avVar.i();
            if (i2 == null) {
            }
        }
    }
}
