package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements PersonPostModel.a {
    final /* synthetic */ aj eLE;
    private final /* synthetic */ boolean eLF;
    private final /* synthetic */ boolean eLG;
    private final /* synthetic */ com.baidu.tieba.person.data.c eLH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aj ajVar, boolean z, boolean z2, com.baidu.tieba.person.data.c cVar) {
        this.eLE = ajVar;
        this.eLF = z;
        this.eLG = z2;
        this.eLH = cVar;
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
            tbPageContext = this.eLE.aas;
            com.baidu.adp.lib.util.k.showToast(tbPageContext.getContext(), personPostModel.getErrorString());
        }
        acVar = this.eLE.eLA;
        acVar.Tx();
        if (this.eLF) {
            list2 = this.eLE.mList;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) list2.get(1);
            if (!z) {
                list3 = this.eLE.mList;
                ArrayList<com.baidu.adp.widget.ListView.v> aPW = ((com.baidu.tieba.person.data.c) list3.get(1)).aPW();
                if (com.baidu.tbadk.core.util.x.r(aPW)) {
                    iVar6 = this.eLE.bwJ;
                    iVar6.VD();
                    return;
                } else if (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                    cVar.jp(false);
                    acVar4 = this.eLE.eLA;
                    acVar4.an(aPW);
                    iVar3 = this.eLE.bwJ;
                    iVar3.dB(true);
                    return;
                } else if (aj.cc(personPostModel.postList) == 0) {
                    cVar.jp(false);
                    acVar6 = this.eLE.eLA;
                    acVar6.an(aPW);
                    iVar5 = this.eLE.bwJ;
                    iVar5.dB(true);
                    return;
                } else {
                    aPW.addAll(personPostModel.postList);
                    iVar4 = this.eLE.bwJ;
                    iVar4.wm();
                    cVar.al(aPW);
                    acVar5 = this.eLE.eLA;
                    acVar5.an(aPW);
                    return;
                }
            }
            cVar.jp(true);
            cVar.al(personPostModel.postList);
            cVar.po(0);
            acVar7 = this.eLE.eLA;
            acVar7.an(personPostModel.postList);
            if (!this.eLG) {
                z3 = this.eLE.beq;
                if (z3) {
                    acVar8 = this.eLE.eLA;
                    acVar8.bms();
                }
            }
            if (cVar.aPW() != null && cVar.aPW().size() == 1 && (cVar.aPW().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                z2 = this.eLE.beq;
                ((com.baidu.tieba.personPolymeric.c.i) cVar.aPW().get(0)).bld = z2;
                iVar7 = this.eLE.bwJ;
                iVar7.VD();
                return;
            }
            return;
        }
        list = this.eLE.mList;
        ArrayList<com.baidu.adp.widget.ListView.v> aPW2 = ((com.baidu.tieba.person.data.c) list.get(0)).aPW();
        if (!com.baidu.tbadk.core.util.x.r(aPW2)) {
            if (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 0 || (com.baidu.tbadk.core.util.x.q(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                this.eLH.jp(false);
                acVar2 = this.eLE.eLA;
                acVar2.an(aPW2);
                iVar = this.eLE.bwJ;
                iVar.dB(true);
                return;
            }
            aPW2.addAll(personPostModel.threadList);
            this.eLH.jp(true);
            this.eLH.al(aPW2);
            iVar2 = this.eLE.bwJ;
            iVar2.wm();
            acVar3 = this.eLE.eLA;
            acVar3.cb(aPW2);
        }
    }
}
