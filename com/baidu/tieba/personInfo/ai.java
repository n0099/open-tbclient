package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements BdListView.e {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
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
        hVar = this.this$0.dwQ;
        if (hVar != null) {
            biVar = this.this$0.dCt;
            if (biVar != null) {
                bfVar = this.this$0.dvN;
                if (bfVar != null) {
                    bfVar2 = this.this$0.dvN;
                    if (!bfVar2.aDA()) {
                        bfVar5 = this.this$0.dvN;
                        if (com.baidu.tbadk.core.util.y.q(bfVar5.aDe())) {
                            biVar6 = this.this$0.dCt;
                            biVar6.aDJ();
                            return;
                        }
                        biVar5 = this.this$0.dCt;
                        biVar5.aCg();
                        return;
                    }
                    hVar2 = this.this$0.dwQ;
                    if (!hVar2.isLoading()) {
                        hVar3 = this.this$0.dwQ;
                        if (hVar3.hasMore()) {
                            bfVar4 = this.this$0.dvN;
                            long c = com.baidu.adp.lib.h.b.c(bfVar4.getId(), 0L);
                            hVar4 = this.this$0.dwQ;
                            hVar4.bG(c);
                            biVar4 = this.this$0.dCt;
                            biVar4.PQ();
                            return;
                        }
                        bfVar3 = this.this$0.dvN;
                        if (com.baidu.tbadk.core.util.y.q(bfVar3.aDe())) {
                            biVar3 = this.this$0.dCt;
                            biVar3.aDJ();
                            return;
                        }
                        biVar2 = this.this$0.dCt;
                        biVar2.aCg();
                    }
                }
            }
        }
    }
}
