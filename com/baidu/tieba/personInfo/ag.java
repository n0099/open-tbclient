package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements BdPersonListView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jm() {
        bj bjVar;
        bg bgVar;
        bj bjVar2;
        boolean z;
        com.baidu.tieba.person.god.h hVar;
        com.baidu.tieba.person.god.h hVar2;
        bj bjVar3;
        if (!com.baidu.adp.lib.util.i.fq()) {
            bjVar = this.this$0.dFA;
            bjVar.Pl();
            return;
        }
        bgVar = this.this$0.dyP;
        bgVar.aDF();
        bjVar2 = this.this$0.dFA;
        if (bjVar2.aEh() != null) {
            bjVar3 = this.this$0.dFA;
            bjVar3.aEh().jk();
        }
        z = this.this$0.bIW;
        if (!z && TbadkCoreApplication.isLogin()) {
            this.this$0.aDe();
        }
        hVar = this.this$0.dzV;
        if (hVar != null) {
            hVar2 = this.this$0.dzV;
            hVar2.reset();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void jl() {
        bj bjVar;
        bj bjVar2;
        bjVar = this.this$0.dFA;
        if (bjVar.aEh() != null) {
            bjVar2 = this.this$0.dFA;
            bjVar2.aEh().Pl();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void k(float f) {
        bj bjVar;
        bj bjVar2;
        bjVar = this.this$0.dFA;
        if (bjVar.aEh() != null) {
            bjVar2 = this.this$0.dFA;
            bjVar2.aEh().j(f);
        }
    }
}
