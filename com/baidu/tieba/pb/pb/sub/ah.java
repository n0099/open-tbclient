package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ew;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements b.a {
    final /* synthetic */ ag eyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.eyq = agVar;
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
        nVar = this.eyq.eyl;
        if (nVar != null) {
            qVar = this.eyq.emB;
            if (qVar != null) {
                nVar2 = this.eyq.eyl;
                if (nVar2.aMT() != null) {
                    nVar3 = this.eyq.eyl;
                    if (nVar3.Jv() != null) {
                        qVar2 = this.eyq.emB;
                        if (qVar2.bjY() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            qVar3 = this.eyq.emB;
                            long templateId = qVar3.bjY().getTemplateId();
                            qVar4 = this.eyq.emB;
                            String bju = qVar4.bjY().bju();
                            nVar4 = this.eyq.eyl;
                            String id = nVar4.aMT().getId();
                            nVar5 = this.eyq.eyl;
                            String name = nVar5.aMT().getName();
                            nVar6 = this.eyq.eyl;
                            com.baidu.tieba.pb.b.a(templateId, bju, str, "PB", str2, str3, "tpoint", str4, str5, id, name, nVar6.Jv().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aLT() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        qVar = this.eyq.emB;
        if (ew.g(qVar)) {
            qVar2 = this.eyq.emB;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> bjr = qVar2.bjY().bjr();
            if (bjr == null) {
                return 0;
            }
            return bjr.size();
        }
        return 0;
    }
}
