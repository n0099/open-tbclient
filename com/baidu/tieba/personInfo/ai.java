package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements BdListView.e {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        com.baidu.tieba.person.god.h hVar;
        bi biVar;
        bf bfVar;
        bf bfVar2;
        com.baidu.tieba.person.god.h hVar2;
        com.baidu.tieba.person.god.h hVar3;
        bf bfVar3;
        bi biVar2;
        bi biVar3;
        bf bfVar4;
        com.baidu.tieba.person.god.h hVar4;
        bi biVar4;
        bf bfVar5;
        bi biVar5;
        bi biVar6;
        hVar = this.diG.dcn;
        if (hVar != null) {
            biVar = this.diG.dhR;
            if (biVar != null) {
                bfVar = this.diG.dbl;
                if (bfVar != null) {
                    bfVar2 = this.diG.dbl;
                    if (!bfVar2.avV()) {
                        bfVar5 = this.diG.dbl;
                        if (com.baidu.tbadk.core.util.x.p(bfVar5.avz())) {
                            biVar6 = this.diG.dhR;
                            biVar6.awe();
                            return;
                        }
                        biVar5 = this.diG.dhR;
                        biVar5.auA();
                        return;
                    }
                    hVar2 = this.diG.dcn;
                    if (!hVar2.isLoading()) {
                        hVar3 = this.diG.dcn;
                        if (hVar3.hasMore()) {
                            bfVar4 = this.diG.dbl;
                            long c = com.baidu.adp.lib.h.b.c(bfVar4.getId(), 0L);
                            hVar4 = this.diG.dcn;
                            hVar4.bp(c);
                            biVar4 = this.diG.dhR;
                            biVar4.Ob();
                            return;
                        }
                        bfVar3 = this.diG.dbl;
                        if (com.baidu.tbadk.core.util.x.p(bfVar3.avz())) {
                            biVar3 = this.diG.dhR;
                            biVar3.awe();
                            return;
                        }
                        biVar2 = this.diG.dhR;
                        biVar2.auA();
                    }
                }
            }
        }
    }
}
