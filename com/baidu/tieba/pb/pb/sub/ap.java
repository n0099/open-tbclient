package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao esl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.esl = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.j jVar;
        com.baidu.tieba.tbadkCore.data.p pVar;
        com.baidu.tieba.pb.data.j jVar2;
        com.baidu.tieba.pb.data.j jVar3;
        com.baidu.tieba.tbadkCore.data.p pVar2;
        com.baidu.tieba.tbadkCore.data.p pVar3;
        com.baidu.tieba.tbadkCore.data.p pVar4;
        com.baidu.tieba.pb.data.j jVar4;
        com.baidu.tieba.pb.data.j jVar5;
        com.baidu.tieba.pb.data.j jVar6;
        jVar = this.esl.eqJ;
        if (jVar != null) {
            pVar = this.esl.efS;
            if (pVar != null) {
                jVar2 = this.esl.eqJ;
                if (jVar2.aKC() != null) {
                    jVar3 = this.esl.eqJ;
                    if (jVar3.Ji() != null) {
                        pVar2 = this.esl.efS;
                        if (pVar2.bhY() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            pVar3 = this.esl.efS;
                            long templateId = pVar3.bhY().getTemplateId();
                            pVar4 = this.esl.efS;
                            String bhv = pVar4.bhY().bhv();
                            jVar4 = this.esl.eqJ;
                            String id = jVar4.aKC().getId();
                            jVar5 = this.esl.eqJ;
                            String name = jVar5.aKC().getName();
                            jVar6 = this.esl.eqJ;
                            com.baidu.tieba.pb.b.a(templateId, bhv, str, "PB", str2, str3, "tpoint", str4, str5, id, name, jVar6.Ji().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aJB() {
        com.baidu.tieba.tbadkCore.data.p pVar;
        com.baidu.tieba.tbadkCore.data.p pVar2;
        pVar = this.esl.efS;
        if (ey.g(pVar)) {
            pVar2 = this.esl.efS;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> bhs = pVar2.bhY().bhs();
            if (bhs == null) {
                return 0;
            }
            return bhs.size();
        }
        return 0;
    }
}
