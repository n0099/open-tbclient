package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements BdPersonListView.a {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jo() {
        bq bqVar;
        bn bnVar;
        bq bqVar2;
        boolean z;
        com.baidu.tieba.person.god.i iVar;
        com.baidu.tieba.person.god.i iVar2;
        bq bqVar3;
        if (!com.baidu.adp.lib.util.i.fq()) {
            bqVar = this.this$0.eAu;
            bqVar.aap();
            return;
        }
        bnVar = this.this$0.ers;
        bnVar.aPI();
        bqVar2 = this.this$0.eAu;
        if (bqVar2.aQh() != null) {
            bqVar3 = this.this$0.eAu;
            bqVar3.aQh().jm();
        }
        z = this.this$0.ciS;
        if (!z && TbadkCoreApplication.isLogin()) {
            this.this$0.aPh();
        }
        iVar = this.this$0.esG;
        if (iVar != null) {
            iVar2 = this.this$0.esG;
            iVar2.reset();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jn() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.this$0.eAu;
        if (bqVar.aQh() != null) {
            bqVar2 = this.this$0.eAu;
            bqVar2.aQh().aap();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void u(float f) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.this$0.eAu;
        if (bqVar.aQh() != null) {
            bqVar2 = this.this$0.eAu;
            bqVar2.aQh().t(f);
        }
    }
}
