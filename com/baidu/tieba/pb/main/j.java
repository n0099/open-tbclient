package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class j implements com.baidu.tieba.pb.sub.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean z, int i, String str, com.baidu.tieba.data.am amVar) {
        bm bmVar;
        bm bmVar2;
        com.baidu.tieba.pb.sub.f fVar;
        bf bfVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bm bmVar3;
        bf bfVar2;
        AntiData h;
        com.baidu.tieba.pb.sub.f fVar3;
        String str2;
        bm bmVar4;
        bf bfVar3;
        String str3;
        com.baidu.tieba.pb.sub.f fVar4;
        bf bfVar4;
        this.a.v();
        bmVar = this.a.D;
        bmVar.b(str);
        bmVar2 = this.a.D;
        bmVar2.F();
        if (!z) {
            if (i == 4 || i == 28) {
                bfVar4 = this.a.x;
                if (bfVar4.m()) {
                    this.a.closeActivity();
                }
            }
        } else if (amVar != null) {
            fVar = this.a.B;
            String b = fVar.b();
            bfVar = this.a.x;
            ArrayList<com.baidu.tieba.data.ai> e = bfVar.p().e();
            int i2 = 0;
            while (true) {
                if (i2 >= e.size()) {
                    break;
                }
                com.baidu.tieba.data.ai aiVar = e.get(i2);
                if (!aiVar.d().equals(b)) {
                    i2++;
                } else {
                    ArrayList<com.baidu.tieba.data.ai> c = amVar.c();
                    aiVar.a(c.size());
                    int size = aiVar.a().size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= 2 || i3 >= c.size()) {
                            break;
                        }
                        aiVar.a().add(amVar.c().get(i3));
                        size = i3 + 1;
                    }
                }
            }
            fVar2 = this.a.B;
            String c2 = fVar2.c();
            if (c2 != null) {
                fVar3 = this.a.B;
                if ("mention".equals(fVar3.c()) || c2.equals("person_post_reply")) {
                    str2 = this.a.J;
                    if (str2 != null) {
                        bmVar4 = this.a.D;
                        bfVar3 = this.a.x;
                        int l = bfVar3.p().l();
                        str3 = this.a.J;
                        boolean z2 = amVar.b() > 1;
                        fVar4 = this.a.B;
                        bmVar4.a(amVar, l, str3, z2, fVar4.g() == 1);
                        h = amVar.h();
                        if (h == null) {
                            Boolean valueOf = Boolean.valueOf(h.isIfvoice());
                            this.a.p = h.getVoice_message();
                            if (amVar.g() != null) {
                                PbActivity.a(this.a, amVar.g().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bmVar3 = this.a.D;
            bfVar2 = this.a.x;
            bmVar3.a(amVar, bfVar2.p().l());
            h = amVar.h();
            if (h == null) {
            }
        }
    }
}
