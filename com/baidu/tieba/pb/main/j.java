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
    public final void a(boolean z, int i, String str, com.baidu.tieba.data.an anVar) {
        bk bkVar;
        bk bkVar2;
        com.baidu.tieba.pb.sub.f fVar;
        bd bdVar;
        com.baidu.tieba.pb.sub.f fVar2;
        bk bkVar3;
        bd bdVar2;
        AntiData h;
        com.baidu.tieba.pb.sub.f fVar3;
        String str2;
        bk bkVar4;
        bd bdVar3;
        String str3;
        com.baidu.tieba.pb.sub.f fVar4;
        bd bdVar4;
        this.a.v();
        bkVar = this.a.D;
        bkVar.b(str);
        bkVar2 = this.a.D;
        bkVar2.F();
        if (!z) {
            if (i == 4 || i == 28) {
                bdVar4 = this.a.x;
                if (bdVar4.m()) {
                    this.a.closeActivity();
                }
            }
        } else if (anVar != null) {
            fVar = this.a.B;
            String b = fVar.b();
            bdVar = this.a.x;
            ArrayList<com.baidu.tieba.data.ai> e = bdVar.p().e();
            int i2 = 0;
            while (true) {
                if (i2 >= e.size()) {
                    break;
                }
                com.baidu.tieba.data.ai aiVar = e.get(i2);
                if (!aiVar.d().equals(b)) {
                    i2++;
                } else {
                    ArrayList<com.baidu.tieba.data.ai> c = anVar.c();
                    aiVar.a(c.size());
                    int size = aiVar.a().size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= 2 || i3 >= c.size()) {
                            break;
                        }
                        aiVar.a().add(anVar.c().get(i3));
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
                        bkVar4 = this.a.D;
                        bdVar3 = this.a.x;
                        int l = bdVar3.p().l();
                        str3 = this.a.J;
                        boolean z2 = anVar.b() > 1;
                        fVar4 = this.a.B;
                        bkVar4.a(anVar, l, str3, z2, fVar4.g() == 1);
                        h = anVar.h();
                        if (h == null) {
                            Boolean valueOf = Boolean.valueOf(h.isIfvoice());
                            this.a.p = h.getVoice_message();
                            if (anVar.g() != null) {
                                PbActivity.a(this.a, anVar.g().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bkVar3 = this.a.D;
            bdVar2 = this.a.x;
            bkVar3.a(anVar, bdVar2.p().l());
            h = anVar.h();
            if (h == null) {
            }
        }
    }
}
