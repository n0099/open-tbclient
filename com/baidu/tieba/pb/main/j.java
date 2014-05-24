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
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.ap apVar) {
        bq bqVar;
        bq bqVar2;
        com.baidu.tieba.pb.sub.f fVar;
        bj bjVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bq bqVar3;
        bj bjVar2;
        AntiData i2;
        com.baidu.tieba.pb.sub.f fVar3;
        String str2;
        bq bqVar4;
        bj bjVar3;
        String str3;
        com.baidu.tieba.pb.sub.f fVar4;
        bj bjVar4;
        this.a.D();
        bqVar = this.a.D;
        bqVar.d(str);
        bqVar2 = this.a.D;
        bqVar2.F();
        if (!z) {
            if (i == 4 || i == 28) {
                bjVar4 = this.a.x;
                if (bjVar4.m()) {
                    this.a.closeActivity();
                }
            }
        } else if (apVar != null) {
            fVar = this.a.B;
            String b = fVar.b();
            bjVar = this.a.x;
            ArrayList<com.baidu.tieba.data.ai> e = bjVar.p().e();
            int i3 = 0;
            while (true) {
                if (i3 < e.size()) {
                    com.baidu.tieba.data.ai aiVar = e.get(i3);
                    if (aiVar.l() == null || !aiVar.l().equals(b)) {
                        i3++;
                    } else {
                        ArrayList<com.baidu.tieba.data.ai> c = apVar.c();
                        aiVar.b(c.size());
                        int size = aiVar.i().size();
                        while (true) {
                            int i4 = size;
                            if (i4 >= 2 || i4 >= c.size()) {
                                break;
                            }
                            aiVar.i().add(apVar.c().get(i4));
                            size = i4 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            fVar2 = this.a.B;
            String c2 = fVar2.c();
            if (c2 != null) {
                fVar3 = this.a.B;
                if ("mention".equals(fVar3.c()) || c2.equals("person_post_reply")) {
                    str2 = this.a.J;
                    if (str2 != null) {
                        bqVar4 = this.a.D;
                        bjVar3 = this.a.x;
                        int l = bjVar3.p().l();
                        str3 = this.a.J;
                        boolean z2 = apVar.b() > 1;
                        fVar4 = this.a.B;
                        bqVar4.a(apVar, l, str3, z2, fVar4.g() == 1);
                        i2 = apVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.a.p = i2.getVoice_message();
                            if (apVar.h() != null) {
                                this.a.a(apVar.h().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bqVar3 = this.a.D;
            bjVar2 = this.a.x;
            bqVar3.a(apVar, bjVar2.p().l());
            i2 = apVar.i();
            if (i2 == null) {
            }
        }
    }
}
