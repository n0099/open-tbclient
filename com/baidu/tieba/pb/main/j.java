package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.au auVar) {
        bs bsVar;
        bs bsVar2;
        com.baidu.tieba.pb.sub.e eVar;
        bl blVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bs bsVar3;
        bl blVar2;
        AntiData j;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bs bsVar4;
        bl blVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bl blVar4;
        this.a.G();
        bsVar = this.a.E;
        bsVar.d(str);
        bsVar2 = this.a.E;
        bsVar2.G();
        if (!z) {
            if (i == 4 || i == 28) {
                blVar4 = this.a.y;
                if (blVar4.o()) {
                    this.a.closeActivity();
                }
            }
        } else if (auVar != null) {
            eVar = this.a.C;
            String b = eVar.b();
            blVar = this.a.y;
            ArrayList<com.baidu.tieba.data.an> e = blVar.r().e();
            int i2 = 0;
            while (true) {
                if (i2 < e.size()) {
                    com.baidu.tieba.data.an anVar = e.get(i2);
                    if (anVar.d() == null || !anVar.d().equals(b)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.data.an> d = auVar.d();
                        anVar.a_(d.size());
                        int size = anVar.n_().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= d.size()) {
                                break;
                            }
                            anVar.n_().add(auVar.d().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.a.C;
            String c = eVar2.c();
            if (c != null) {
                eVar3 = this.a.C;
                if ("mention".equals(eVar3.c()) || c.equals("person_post_reply")) {
                    str2 = this.a.K;
                    if (str2 != null) {
                        bsVar4 = this.a.E;
                        blVar3 = this.a.y;
                        int l = blVar3.r().l();
                        str3 = this.a.K;
                        boolean z2 = auVar.c() > 1;
                        eVar4 = this.a.C;
                        bsVar4.a(auVar, l, str3, z2, eVar4.h() == 1);
                        j = auVar.j();
                        if (j == null) {
                            Boolean valueOf = Boolean.valueOf(j.isIfvoice());
                            this.a.q = j.getVoice_message();
                            if (auVar.i() != null) {
                                this.a.a(auVar.i().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bsVar3 = this.a.E;
            blVar2 = this.a.y;
            bsVar3.a(auVar, blVar2.r().l());
            j = auVar.j();
            if (j == null) {
            }
        }
    }
}
