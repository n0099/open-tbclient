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
    public void a(boolean z, int i, String str, com.baidu.tieba.data.at atVar) {
        bt btVar;
        bt btVar2;
        com.baidu.tieba.pb.sub.f fVar;
        bm bmVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bt btVar3;
        bm bmVar2;
        AntiData i2;
        com.baidu.tieba.pb.sub.f fVar3;
        String str2;
        bt btVar4;
        bm bmVar3;
        String str3;
        com.baidu.tieba.pb.sub.f fVar4;
        bm bmVar4;
        this.a.D();
        btVar = this.a.D;
        btVar.d(str);
        btVar2 = this.a.D;
        btVar2.G();
        if (!z) {
            if (i == 4 || i == 28) {
                bmVar4 = this.a.x;
                if (bmVar4.o()) {
                    this.a.closeActivity();
                }
            }
        } else if (atVar != null) {
            fVar = this.a.B;
            String b = fVar.b();
            bmVar = this.a.x;
            ArrayList<com.baidu.tieba.data.am> d = bmVar.r().d();
            int i3 = 0;
            while (true) {
                if (i3 < d.size()) {
                    com.baidu.tieba.data.am amVar = d.get(i3);
                    if (amVar.l() == null || !amVar.l().equals(b)) {
                        i3++;
                    } else {
                        ArrayList<com.baidu.tieba.data.am> c = atVar.c();
                        amVar.b(c.size());
                        int size = amVar.i().size();
                        while (true) {
                            int i4 = size;
                            if (i4 >= 2 || i4 >= c.size()) {
                                break;
                            }
                            amVar.i().add(atVar.c().get(i4));
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
                        btVar4 = this.a.D;
                        bmVar3 = this.a.x;
                        int k = bmVar3.r().k();
                        str3 = this.a.J;
                        boolean z2 = atVar.b() > 1;
                        fVar4 = this.a.B;
                        btVar4.a(atVar, k, str3, z2, fVar4.h() == 1);
                        i2 = atVar.i();
                        if (i2 == null) {
                            Boolean valueOf = Boolean.valueOf(i2.isIfvoice());
                            this.a.p = i2.getVoice_message();
                            if (atVar.h() != null) {
                                this.a.a(atVar.h().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            btVar3 = this.a.D;
            bmVar2 = this.a.x;
            btVar3.a(atVar, bmVar2.r().k());
            i2 = atVar.i();
            if (i2 == null) {
            }
        }
    }
}
