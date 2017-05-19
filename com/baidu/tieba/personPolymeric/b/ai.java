package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements PersonPostModel.a {
    final /* synthetic */ ab eCS;
    private final /* synthetic */ boolean eCT;
    private final /* synthetic */ boolean eCU;
    private final /* synthetic */ com.baidu.tieba.person.data.c eCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ab abVar, boolean z, boolean z2, com.baidu.tieba.person.data.c cVar) {
        this.eCS = abVar;
        this.eCT = z;
        this.eCU = z2;
        this.eCV = cVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        com.baidu.tieba.personPolymeric.d.ab abVar;
        List list;
        com.baidu.tieba.personPolymeric.d.ab abVar2;
        com.baidu.tieba.personPolymeric.d.ab abVar3;
        com.baidu.tieba.personPolymeric.d.ab abVar4;
        com.baidu.tieba.personPolymeric.d.ab abVar5;
        List list2;
        List list3;
        com.baidu.tieba.personPolymeric.d.ab abVar6;
        com.baidu.tieba.personPolymeric.d.ab abVar7;
        com.baidu.tieba.personPolymeric.d.ab abVar8;
        com.baidu.tieba.personPolymeric.d.ab abVar9;
        com.baidu.tieba.personPolymeric.d.ab abVar10;
        com.baidu.tieba.personPolymeric.d.ab abVar11;
        com.baidu.tieba.personPolymeric.d.ab abVar12;
        com.baidu.tieba.personPolymeric.d.ab abVar13;
        com.baidu.tieba.personPolymeric.d.ab abVar14;
        com.baidu.tieba.personPolymeric.d.ab abVar15;
        TbPageContext tbPageContext;
        if (personPostModel.getErrorCode() != 0) {
            tbPageContext = this.eCS.aat;
            com.baidu.adp.lib.util.k.showToast(tbPageContext.getContext(), personPostModel.getErrorString());
        }
        abVar = this.eCS.eCL;
        abVar.acw();
        if (this.eCT) {
            list2 = this.eCS.mList;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) list2.get(1);
            if (!z) {
                list3 = this.eCS.mList;
                ArrayList<com.baidu.adp.widget.ListView.v> aOG = ((com.baidu.tieba.person.data.c) list3.get(1)).aOG();
                if (com.baidu.tbadk.core.util.x.r(aOG)) {
                    abVar12 = this.eCS.eCL;
                    abVar12.UA();
                    return;
                } else if (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.h))) {
                    cVar.iW(false);
                    abVar6 = this.eCS.eCL;
                    abVar6.an(aOG);
                    abVar7 = this.eCS.eCL;
                    abVar7.dk(true);
                    return;
                } else if (ab.bZ(personPostModel.postList) == 0) {
                    cVar.iW(false);
                    abVar10 = this.eCS.eCL;
                    abVar10.an(aOG);
                    abVar11 = this.eCS.eCL;
                    abVar11.dk(true);
                    return;
                } else {
                    aOG.addAll(personPostModel.postList);
                    abVar8 = this.eCS.eCL;
                    abVar8.wp();
                    cVar.al(aOG);
                    abVar9 = this.eCS.eCL;
                    abVar9.an(aOG);
                    return;
                }
            }
            cVar.iW(true);
            cVar.al(personPostModel.postList);
            cVar.oP(0);
            abVar13 = this.eCS.eCL;
            abVar13.an(personPostModel.postList);
            if (!this.eCU) {
                abVar15 = this.eCS.eCL;
                abVar15.bkV();
            }
            if (cVar.aOG() != null && cVar.aOG().size() == 1 && (cVar.aOG().get(0) instanceof com.baidu.tieba.personPolymeric.c.h)) {
                abVar14 = this.eCS.eCL;
                abVar14.UA();
                return;
            }
            return;
        }
        list = this.eCS.mList;
        ArrayList<com.baidu.adp.widget.ListView.v> aOG2 = ((com.baidu.tieba.person.data.c) list.get(0)).aOG();
        if (!com.baidu.tbadk.core.util.x.r(aOG2)) {
            if (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.h))) {
                this.eCV.iW(false);
                abVar2 = this.eCS.eCL;
                abVar2.an(aOG2);
                abVar3 = this.eCS.eCL;
                abVar3.dk(true);
                return;
            }
            aOG2.addAll(personPostModel.threadList);
            this.eCV.iW(true);
            this.eCV.al(aOG2);
            abVar4 = this.eCS.eCL;
            abVar4.wp();
            abVar5 = this.eCS.eCL;
            abVar5.cK(aOG2);
        }
    }
}
