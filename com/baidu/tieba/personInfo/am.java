package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements BdListView.e {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        com.baidu.tieba.person.god.i iVar;
        bs bsVar;
        bp bpVar;
        bp bpVar2;
        com.baidu.tieba.person.god.i iVar2;
        com.baidu.tieba.person.god.i iVar3;
        bp bpVar3;
        bs bsVar2;
        bs bsVar3;
        bp bpVar4;
        com.baidu.tieba.person.god.i iVar4;
        bs bsVar4;
        bp bpVar5;
        bs bsVar5;
        bs bsVar6;
        iVar = this.this$0.eiC;
        if (iVar != null) {
            bsVar = this.this$0.eoE;
            if (bsVar != null) {
                bpVar = this.this$0.eht;
                if (bpVar != null) {
                    bpVar2 = this.this$0.eht;
                    if (!bpVar2.aMU()) {
                        bpVar5 = this.this$0.eht;
                        if (com.baidu.tbadk.core.util.y.t(bpVar5.aMx())) {
                            bsVar6 = this.this$0.eoE;
                            bsVar6.aNd();
                            return;
                        }
                        bsVar5 = this.this$0.eoE;
                        bsVar5.aLv();
                        return;
                    }
                    iVar2 = this.this$0.eiC;
                    if (!iVar2.DK()) {
                        iVar3 = this.this$0.eiC;
                        if (iVar3.hasMore()) {
                            bpVar4 = this.this$0.eht;
                            long c = com.baidu.adp.lib.h.b.c(bpVar4.getId(), 0L);
                            iVar4 = this.this$0.eiC;
                            iVar4.co(c);
                            bsVar4 = this.this$0.eoE;
                            bsVar4.Un();
                            return;
                        }
                        bpVar3 = this.this$0.eht;
                        if (com.baidu.tbadk.core.util.y.t(bpVar3.aMx())) {
                            bsVar3 = this.this$0.eoE;
                            bsVar3.aNd();
                            return;
                        }
                        bsVar2 = this.this$0.eoE;
                        bsVar2.aLv();
                    }
                }
            }
        }
    }
}
