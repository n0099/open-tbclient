package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements BdPersonListView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void mY() {
        bi biVar;
        bf bfVar;
        bi biVar2;
        boolean z;
        com.baidu.tieba.person.god.h hVar;
        com.baidu.tieba.person.god.h hVar2;
        bi biVar3;
        if (!com.baidu.adp.lib.util.i.jf()) {
            biVar = this.this$0.dCt;
            biVar.Qo();
            return;
        }
        bfVar = this.this$0.dvN;
        bfVar.aDk();
        biVar2 = this.this$0.dCt;
        if (biVar2.aDK() != null) {
            biVar3 = this.this$0.dCt;
            biVar3.aDK().mW();
        }
        z = this.this$0.bIP;
        if (!z && TbadkCoreApplication.isLogin()) {
            this.this$0.aCK();
        }
        hVar = this.this$0.dwQ;
        if (hVar != null) {
            hVar2 = this.this$0.dwQ;
            hVar2.reset();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void mX() {
        bi biVar;
        bi biVar2;
        biVar = this.this$0.dCt;
        if (biVar.aDK() != null) {
            biVar2 = this.this$0.dCt;
            biVar2.aDK().Qo();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void m(float f) {
        bi biVar;
        bi biVar2;
        biVar = this.this$0.dCt;
        if (biVar.aDK() != null) {
            biVar2 = this.this$0.dCt;
            biVar2.aDK().l(f);
        }
    }
}
