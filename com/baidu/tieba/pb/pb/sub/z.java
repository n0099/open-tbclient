package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ek;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements b.a {
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.dqN = yVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void z(String str, String str2, String str3) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        com.baidu.tieba.tbadkCore.data.s sVar3;
        com.baidu.tieba.tbadkCore.data.s sVar4;
        com.baidu.tieba.pb.data.h hVar4;
        com.baidu.tieba.pb.data.h hVar5;
        com.baidu.tieba.pb.data.h hVar6;
        hVar = this.dqN.dqL;
        if (hVar != null) {
            sVar = this.dqN.dfs;
            if (sVar != null) {
                hVar2 = this.dqN.dqL;
                if (hVar2.avY() != null) {
                    hVar3 = this.dqN.dqL;
                    if (hVar3.Kn() != null) {
                        sVar2 = this.dqN.dfs;
                        if (sVar2.aUi() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            sVar3 = this.dqN.dfs;
                            long templateId = sVar3.aUi().getTemplateId();
                            sVar4 = this.dqN.dfs;
                            String aTC = sVar4.aUi().aTC();
                            hVar4 = this.dqN.dqL;
                            String id = hVar4.avY().getId();
                            hVar5 = this.dqN.dqL;
                            String name = hVar5.avY().getName();
                            hVar6 = this.dqN.dqL;
                            com.baidu.tieba.pb.b.a(templateId, aTC, str, "PB", str2, str3, "tpoint", id, name, hVar6.Kn().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int avk() {
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        sVar = this.dqN.dfs;
        if (ek.g(sVar)) {
            sVar2 = this.dqN.dfs;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aTz = sVar2.aUi().aTz();
            if (aTz == null) {
                return 0;
            }
            return aTz.size();
        }
        return 0;
    }
}
