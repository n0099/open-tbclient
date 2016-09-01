package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ew;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements b.a {
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.ewi = agVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.m mVar;
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.pb.data.m mVar2;
        com.baidu.tieba.pb.data.m mVar3;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        com.baidu.tieba.tbadkCore.data.q qVar3;
        com.baidu.tieba.tbadkCore.data.q qVar4;
        com.baidu.tieba.pb.data.m mVar4;
        com.baidu.tieba.pb.data.m mVar5;
        com.baidu.tieba.pb.data.m mVar6;
        mVar = this.ewi.ewe;
        if (mVar != null) {
            qVar = this.ewi.ekz;
            if (qVar != null) {
                mVar2 = this.ewi.ewe;
                if (mVar2.aMn() != null) {
                    mVar3 = this.ewi.ewe;
                    if (mVar3.Kw() != null) {
                        qVar2 = this.ewi.ekz;
                        if (qVar2.bjm() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            qVar3 = this.ewi.ekz;
                            long templateId = qVar3.bjm().getTemplateId();
                            qVar4 = this.ewi.ekz;
                            String biJ = qVar4.bjm().biJ();
                            mVar4 = this.ewi.ewe;
                            String id = mVar4.aMn().getId();
                            mVar5 = this.ewi.ewe;
                            String name = mVar5.aMn().getName();
                            mVar6 = this.ewi.ewe;
                            com.baidu.tieba.pb.b.a(templateId, biJ, str, "PB", str2, str3, "tpoint", str4, str5, id, name, mVar6.Kw().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aLr() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        qVar = this.ewi.ekz;
        if (ew.g(qVar)) {
            qVar2 = this.ewi.ekz;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> biG = qVar2.bjm().biG();
            if (biG == null) {
                return 0;
            }
            return biG.size();
        }
        return 0;
    }
}
