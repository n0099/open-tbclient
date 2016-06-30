package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements BdPersonListView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jp() {
        bs bsVar;
        bp bpVar;
        bs bsVar2;
        boolean z;
        com.baidu.tieba.person.god.i iVar;
        com.baidu.tieba.person.god.i iVar2;
        bs bsVar3;
        if (!com.baidu.adp.lib.util.i.fr()) {
            bsVar = this.this$0.eoE;
            bsVar.US();
            return;
        }
        bpVar = this.this$0.eht;
        bpVar.aMD();
        bsVar2 = this.this$0.eoE;
        if (bsVar2.aNe() != null) {
            bsVar3 = this.this$0.eoE;
            bsVar3.aNe().jn();
        }
        z = this.this$0.cgJ;
        if (!z && TbadkCoreApplication.isLogin()) {
            this.this$0.aMc();
        }
        iVar = this.this$0.eiC;
        if (iVar != null) {
            iVar2 = this.this$0.eiC;
            iVar2.reset();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jo() {
        bs bsVar;
        bs bsVar2;
        bsVar = this.this$0.eoE;
        if (bsVar.aNe() != null) {
            bsVar2 = this.this$0.eoE;
            bsVar2.aNe().US();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void k(float f) {
        bs bsVar;
        bs bsVar2;
        bsVar = this.this$0.eoE;
        if (bsVar.aNe() != null) {
            bsVar2 = this.this$0.eoE;
            bsVar2.aNe().j(f);
        }
    }
}
