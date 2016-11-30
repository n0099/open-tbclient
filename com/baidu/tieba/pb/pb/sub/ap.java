package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ex;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.eFb = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.n nVar;
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.pb.data.n nVar2;
        com.baidu.tieba.pb.data.n nVar3;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        com.baidu.tieba.tbadkCore.data.q qVar3;
        com.baidu.tieba.tbadkCore.data.q qVar4;
        com.baidu.tieba.pb.data.n nVar4;
        com.baidu.tieba.pb.data.n nVar5;
        com.baidu.tieba.pb.data.n nVar6;
        nVar = this.eFb.eDA;
        if (nVar != null) {
            qVar = this.eFb.esy;
            if (qVar != null) {
                nVar2 = this.eFb.eDA;
                if (nVar2.aOM() != null) {
                    nVar3 = this.eFb.eDA;
                    if (nVar3.Jz() != null) {
                        qVar2 = this.eFb.esy;
                        if (qVar2.bmt() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            qVar3 = this.eFb.esy;
                            long templateId = qVar3.bmt().getTemplateId();
                            qVar4 = this.eFb.esy;
                            String blQ = qVar4.bmt().blQ();
                            nVar4 = this.eFb.eDA;
                            String id = nVar4.aOM().getId();
                            nVar5 = this.eFb.eDA;
                            String name = nVar5.aOM().getName();
                            nVar6 = this.eFb.eDA;
                            com.baidu.tieba.pb.b.a(templateId, blQ, str, "PB", str2, str3, "tpoint", str4, str5, id, name, nVar6.Jz().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aNM() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        qVar = this.eFb.esy;
        if (ex.h(qVar)) {
            qVar2 = this.eFb.esy;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> blN = qVar2.bmt().blN();
            if (blN == null) {
                return 0;
            }
            return blN.size();
        }
        return 0;
    }
}
