package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.pb.sub.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.ao aoVar) {
        bj bjVar;
        bj bjVar2;
        com.baidu.tieba.pb.sub.f fVar;
        bc bcVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bj bjVar3;
        bc bcVar2;
        AntiData i2;
        com.baidu.tieba.pb.sub.f fVar3;
        String str2;
        bj bjVar4;
        bc bcVar3;
        String str3;
        com.baidu.tieba.pb.sub.f fVar4;
        bc bcVar4;
        this.a.C();
        bjVar = this.a.E;
        bjVar.d(str);
        bjVar2 = this.a.E;
        bjVar2.F();
        if (!z) {
            if (i == 4 || i == 28) {
                bcVar4 = this.a.y;
                if (bcVar4.m()) {
                    this.a.closeActivity();
                }
            }
        } else if (aoVar != null) {
            fVar = this.a.C;
            String b = fVar.b();
            bcVar = this.a.y;
            ArrayList<com.baidu.tieba.data.ah> e = bcVar.p().e();
            int i3 = 0;
            while (true) {
                if (i3 >= e.size()) {
                    break;
                }
                com.baidu.tieba.data.ah ahVar = e.get(i3);
                if (!ahVar.d().equals(b)) {
                    i3++;
                } else {
                    ArrayList<com.baidu.tieba.data.ah> c = aoVar.c();
                    ahVar.a(c.size());
                    int size = ahVar.a().size();
                    while (true) {
                        int i4 = size;
                        if (i4 >= 2 || i4 >= c.size()) {
                            break;
                        }
                        ahVar.a().add(aoVar.c().get(i4));
                        size = i4 + 1;
                    }
                }
            }
            fVar2 = this.a.C;
            String c2 = fVar2.c();
            if (c2 != null) {
                fVar3 = this.a.C;
                if ("mention".equals(fVar3.c()) || c2.equals("person_post_reply")) {
                    str2 = this.a.K;
                    if (str2 != null) {
                        bjVar4 = this.a.E;
                        bcVar3 = this.a.y;
                        int l = bcVar3.p().l();
                        str3 = this.a.K;
                        boolean z2 = aoVar.b() > 1;
                        fVar4 = this.a.C;
                        bjVar4.a(aoVar, l, str3, z2, fVar4.g() == 1);
                        i2 = aoVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.a.p = i2.getVoice_message();
                            if (aoVar.h() != null) {
                                this.a.a(aoVar.h().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bjVar3 = this.a.E;
            bcVar2 = this.a.y;
            bjVar3.a(aoVar, bcVar2.p().l());
            i2 = aoVar.i();
            if (i2 == null) {
            }
        }
    }
}
