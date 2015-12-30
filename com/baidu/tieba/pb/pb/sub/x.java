package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.pb.main.dj;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.InterfaceC0072a {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cLC = wVar;
    }

    @Override // com.baidu.tieba.pb.a.InterfaceC0072a
    public void t(String str, String str2, String str3) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        com.baidu.tieba.tbadkCore.data.r rVar3;
        com.baidu.tieba.tbadkCore.data.r rVar4;
        com.baidu.tieba.pb.a.d dVar4;
        com.baidu.tieba.pb.a.d dVar5;
        com.baidu.tieba.pb.a.d dVar6;
        dVar = this.cLC.cLA;
        if (dVar != null) {
            rVar = this.cLC.cDb;
            if (rVar != null) {
                dVar2 = this.cLC.cLA;
                if (dVar2.akZ() != null) {
                    dVar3 = this.cLC.cLA;
                    if (dVar3.Iv() != null) {
                        rVar2 = this.cLC.cDb;
                        if (rVar2.aFA() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            rVar3 = this.cLC.cDb;
                            long templateId = rVar3.aFA().getTemplateId();
                            rVar4 = this.cLC.cDb;
                            String aEU = rVar4.aFA().aEU();
                            dVar4 = this.cLC.cLA;
                            String id = dVar4.akZ().getId();
                            dVar5 = this.cLC.cLA;
                            String name = dVar5.akZ().getName();
                            dVar6 = this.cLC.cLA;
                            com.baidu.tieba.pb.a.a(templateId, aEU, str, "PB", str2, str3, "tpoint", id, name, dVar6.Iv().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.a.InterfaceC0072a
    public int akq() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        rVar = this.cLC.cDb;
        if (dj.e(rVar)) {
            rVar2 = this.cLC.cDb;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aER = rVar2.aFA().aER();
            if (aER == null) {
                return 0;
            }
            return aER.size();
        }
        return 0;
    }
}
