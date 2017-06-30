package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements PersonPostModel.a {
    final /* synthetic */ ak eVM;
    private final /* synthetic */ boolean eVN;
    private final /* synthetic */ boolean eVO;
    private final /* synthetic */ com.baidu.tieba.person.data.c eVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ak akVar, boolean z, boolean z2, com.baidu.tieba.person.data.c cVar) {
        this.eVM = akVar;
        this.eVN = z;
        this.eVO = z2;
        this.eVP = cVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        com.baidu.tieba.personPolymeric.d.ac acVar;
        List list;
        com.baidu.tieba.personPolymeric.d.ac acVar2;
        i iVar;
        i iVar2;
        com.baidu.tieba.personPolymeric.d.ac acVar3;
        List list2;
        List list3;
        com.baidu.tieba.personPolymeric.d.ac acVar4;
        i iVar3;
        i iVar4;
        com.baidu.tieba.personPolymeric.d.ac acVar5;
        com.baidu.tieba.personPolymeric.d.ac acVar6;
        i iVar5;
        i iVar6;
        com.baidu.tieba.personPolymeric.d.ac acVar7;
        boolean z2;
        i iVar7;
        boolean z3;
        com.baidu.tieba.personPolymeric.d.ac acVar8;
        TbPageContext tbPageContext;
        if (personPostModel.getErrorCode() != 0) {
            tbPageContext = this.eVM.aat;
            com.baidu.adp.lib.util.k.showToast(tbPageContext.getContext(), personPostModel.getErrorString());
        }
        acVar = this.eVM.eVF;
        acVar.ahs();
        if (this.eVN) {
            list2 = this.eVM.mList;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) list2.get(1);
            if (!z) {
                list3 = this.eVM.mList;
                ArrayList<com.baidu.adp.widget.ListView.v> aTX = ((com.baidu.tieba.person.data.c) list3.get(1)).aTX();
                if (com.baidu.tbadk.core.util.z.t(aTX)) {
                    iVar6 = this.eVM.eVJ;
                    iVar6.WU();
                    return;
                } else if (com.baidu.tbadk.core.util.z.s(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.z.s(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                    cVar.jN(false);
                    acVar4 = this.eVM.eVF;
                    acVar4.ao(aTX);
                    iVar3 = this.eVM.eVJ;
                    iVar3.dD(true);
                    return;
                } else if (ak.cr(personPostModel.postList) == 0) {
                    cVar.jN(false);
                    acVar6 = this.eVM.eVF;
                    acVar6.ao(aTX);
                    iVar5 = this.eVM.eVJ;
                    iVar5.dD(true);
                    return;
                } else {
                    aTX.addAll(personPostModel.postList);
                    iVar4 = this.eVM.eVJ;
                    iVar4.wE();
                    cVar.an(aTX);
                    acVar5 = this.eVM.eVF;
                    acVar5.ao(aTX);
                    return;
                }
            }
            cVar.jN(true);
            cVar.an(personPostModel.postList);
            cVar.pI(0);
            acVar7 = this.eVM.eVF;
            acVar7.ao(personPostModel.postList);
            if (!this.eVO) {
                z3 = this.eVM.bhl;
                if (z3) {
                    acVar8 = this.eVM.eVF;
                    acVar8.bqC();
                }
            }
            if (cVar.aTX() != null && cVar.aTX().size() == 1 && (cVar.aTX().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                z2 = this.eVM.bhl;
                ((com.baidu.tieba.personPolymeric.c.i) cVar.aTX().get(0)).boT = z2;
                iVar7 = this.eVM.eVJ;
                iVar7.WU();
                return;
            }
            return;
        }
        list = this.eVM.mList;
        ArrayList<com.baidu.adp.widget.ListView.v> aTX2 = ((com.baidu.tieba.person.data.c) list.get(0)).aTX();
        if (!com.baidu.tbadk.core.util.z.t(aTX2)) {
            if (com.baidu.tbadk.core.util.z.s(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.z.s(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                this.eVP.jN(false);
                acVar2 = this.eVM.eVF;
                acVar2.ao(aTX2);
                iVar = this.eVM.eVJ;
                iVar.dD(true);
                return;
            }
            aTX2.addAll(personPostModel.threadList);
            this.eVP.jN(true);
            this.eVP.an(aTX2);
            iVar2 = this.eVM.eVJ;
            iVar2.wE();
            acVar3 = this.eVM.eVF;
            acVar3.cq(aTX2);
        }
    }
}
