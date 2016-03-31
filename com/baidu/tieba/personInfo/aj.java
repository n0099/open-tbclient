package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.god.h;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements h.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void d(int i, List<ThreadInfo> list) {
        bi biVar;
        bf bfVar;
        bf bfVar2;
        bi biVar2;
        biVar = this.this$0.dCt;
        if (biVar != null) {
            bfVar = this.this$0.dvN;
            if (bfVar != null) {
                bfVar2 = this.this$0.dvN;
                bfVar2.bP(list);
                biVar2 = this.this$0.dCt;
                biVar2.aDM();
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fC(String str) {
        com.baidu.tieba.person.god.h hVar;
        bi biVar;
        bf bfVar;
        bi biVar2;
        bi biVar3;
        hVar = this.this$0.dwQ;
        if (hVar != null) {
            biVar = this.this$0.dCt;
            if (biVar != null) {
                bfVar = this.this$0.dvN;
                if (com.baidu.tbadk.core.util.y.q(bfVar.aDe())) {
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
