package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.eq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao ejb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.ejb = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.j jVar;
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.pb.data.j jVar2;
        com.baidu.tieba.pb.data.j jVar3;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        com.baidu.tieba.tbadkCore.data.q qVar3;
        com.baidu.tieba.tbadkCore.data.q qVar4;
        com.baidu.tieba.pb.data.j jVar4;
        com.baidu.tieba.pb.data.j jVar5;
        com.baidu.tieba.pb.data.j jVar6;
        jVar = this.ejb.ehB;
        if (jVar != null) {
            qVar = this.ejb.dWW;
            if (qVar != null) {
                jVar2 = this.ejb.ehB;
                if (jVar2.aIL() != null) {
                    jVar3 = this.ejb.ehB;
                    if (jVar3.IU() != null) {
                        qVar2 = this.ejb.dWW;
                        if (qVar2.bgi() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            qVar3 = this.ejb.dWW;
                            long templateId = qVar3.bgi().getTemplateId();
                            qVar4 = this.ejb.dWW;
                            String bfF = qVar4.bgi().bfF();
                            jVar4 = this.ejb.ehB;
                            String id = jVar4.aIL().getId();
                            jVar5 = this.ejb.ehB;
                            String name = jVar5.aIL().getName();
                            jVar6 = this.ejb.ehB;
                            com.baidu.tieba.pb.b.a(templateId, bfF, str, "PB", str2, str3, "tpoint", str4, str5, id, name, jVar6.IU().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aHN() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        qVar = this.ejb.dWW;
        if (eq.h(qVar)) {
            qVar2 = this.ejb.dWW;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> bfC = qVar2.bgi().bfC();
            if (bfC == null) {
                return 0;
            }
            return bfC.size();
        }
        return 0;
    }
}
