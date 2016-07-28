package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.god.i;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements i.a {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void c(int i, List<ThreadInfo> list) {
        bq bqVar;
        bn bnVar;
        bn bnVar2;
        bq bqVar2;
        bqVar = this.this$0.eAu;
        if (bqVar != null) {
            bnVar = this.this$0.ers;
            if (bnVar != null) {
                bnVar2 = this.this$0.ers;
                bnVar2.cB(list);
                bqVar2 = this.this$0.eAu;
                bqVar2.aQj();
            }
        }
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void fD(String str) {
        com.baidu.tieba.person.god.i iVar;
        bq bqVar;
        bn bnVar;
        bq bqVar2;
        bq bqVar3;
        iVar = this.this$0.esG;
        if (iVar != null) {
            bqVar = this.this$0.eAu;
            if (bqVar != null) {
                bnVar = this.this$0.ers;
                if (com.baidu.tbadk.core.util.y.t(bnVar.aPC())) {
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
