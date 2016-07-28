package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements BdListView.e {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        com.baidu.tieba.person.god.i iVar;
        bq bqVar;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.person.god.i iVar2;
        com.baidu.tieba.person.god.i iVar3;
        bn bnVar3;
        bq bqVar2;
        bq bqVar3;
        bn bnVar4;
        com.baidu.tieba.person.god.i iVar4;
        bq bqVar4;
        bn bnVar5;
        bq bqVar5;
        bq bqVar6;
        iVar = this.this$0.esG;
        if (iVar != null) {
            bqVar = this.this$0.eAu;
            if (bqVar != null) {
                bnVar = this.this$0.ers;
                if (bnVar != null) {
                    bnVar2 = this.this$0.ers;
                    if (!bnVar2.aPX()) {
                        bnVar5 = this.this$0.ers;
                        if (com.baidu.tbadk.core.util.y.t(bnVar5.aPC())) {
                            bqVar6 = this.this$0.eAu;
                            bqVar6.aQg();
                            return;
                        }
                        bqVar5 = this.this$0.eAu;
                        bqVar5.aNY();
                        return;
                    }
                    iVar2 = this.this$0.esG;
                    if (!iVar2.DJ()) {
                        iVar3 = this.this$0.esG;
                        if (iVar3.hasMore()) {
                            bnVar4 = this.this$0.ers;
                            long c = com.baidu.adp.lib.h.b.c(bnVar4.getId(), 0L);
                            iVar4 = this.this$0.esG;
                            iVar4.cn(c);
                            bqVar4 = this.this$0.eAu;
                            bqVar4.UV();
                            return;
                        }
                        bnVar3 = this.this$0.ers;
                        if (com.baidu.tbadk.core.util.y.t(bnVar3.aPC())) {
                            bqVar3 = this.this$0.eAu;
                            bqVar3.aQg();
                            return;
                        }
                        bqVar2 = this.this$0.eAu;
                        bqVar2.aNY();
                    }
                }
            }
        }
    }
}
