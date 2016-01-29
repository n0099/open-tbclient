package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements BdPersonListView.a {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void nh() {
        bi biVar;
        bf bfVar;
        bi biVar2;
        boolean z;
        com.baidu.tieba.person.god.h hVar;
        com.baidu.tieba.person.god.h hVar2;
        bi biVar3;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            biVar = this.diG.dhR;
            biVar.Oz();
            return;
        }
        bfVar = this.diG.dbl;
        bfVar.avF();
        biVar2 = this.diG.dhR;
        if (biVar2.awf() != null) {
            biVar3 = this.diG.dhR;
            biVar3.awf().nf();
        }
        z = this.diG.bDs;
        if (!z && TbadkCoreApplication.isLogin()) {
            this.diG.ave();
        }
        hVar = this.diG.dcn;
        if (hVar != null) {
            hVar2 = this.diG.dcn;
            hVar2.reset();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ng() {
        bi biVar;
        bi biVar2;
        biVar = this.diG.dhR;
        if (biVar.awf() != null) {
            biVar2 = this.diG.dhR;
            biVar2.awf().Oz();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void m(float f) {
        bi biVar;
        bi biVar2;
        biVar = this.diG.dhR;
        if (biVar.awf() != null) {
            biVar2 = this.diG.dhR;
            biVar2.awf().l(f);
        }
    }
}
