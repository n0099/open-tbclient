package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.god.h;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements h.a {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void c(int i, List<ThreadInfo> list) {
        bi biVar;
        bf bfVar;
        bf bfVar2;
        bi biVar2;
        biVar = this.diG.dhR;
        if (biVar != null) {
            bfVar = this.diG.dbl;
            if (bfVar != null) {
                bfVar2 = this.diG.dbl;
                bfVar2.bt(list);
                biVar2 = this.diG.dhR;
                biVar2.awh();
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fu(String str) {
        com.baidu.tieba.person.god.h hVar;
        bi biVar;
        bf bfVar;
        bi biVar2;
        bi biVar3;
        hVar = this.diG.dcn;
        if (hVar != null) {
            biVar = this.diG.dhR;
            if (biVar != null) {
                bfVar = this.diG.dbl;
                if (com.baidu.tbadk.core.util.x.p(bfVar.avz())) {
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
