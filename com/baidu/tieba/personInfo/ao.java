package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.god.i;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements i.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void c(int i, List<ThreadInfo> list) {
        bs bsVar;
        bp bpVar;
        bp bpVar2;
        bs bsVar2;
        bsVar = this.this$0.eoE;
        if (bsVar != null) {
            bpVar = this.this$0.eht;
            if (bpVar != null) {
                bpVar2 = this.this$0.eht;
                bpVar2.cp(list);
                bsVar2 = this.this$0.eoE;
                bsVar2.aNg();
            }
        }
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void fF(String str) {
        com.baidu.tieba.person.god.i iVar;
        bs bsVar;
        bp bpVar;
        bs bsVar2;
        bs bsVar3;
        iVar = this.this$0.eiC;
        if (iVar != null) {
            bsVar = this.this$0.eoE;
            if (bsVar != null) {
                bpVar = this.this$0.eht;
                if (com.baidu.tbadk.core.util.y.t(bpVar.aMx())) {
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
