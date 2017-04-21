package com.baidu.tieba.personCenter.f;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.g.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g eDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.eDF = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f7  */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.personCenter.c.a aVar;
        w wVar;
        w wVar2;
        w wVar3;
        com.baidu.tieba.personCenter.c.a aVar2;
        boolean z;
        BdPersonListView bdPersonListView;
        com.baidu.tieba.personCenter.c.a aVar3;
        com.baidu.tieba.personCenter.c.a aVar4;
        com.baidu.tieba.personCenter.c.a aVar5;
        com.baidu.tieba.personCenter.c.a aVar6;
        com.baidu.tieba.personCenter.c.a aVar7;
        com.baidu.tieba.personCenter.c.a aVar8;
        com.baidu.tieba.personCenter.c.a aVar9;
        com.baidu.tieba.personCenter.c.a aVar10;
        com.baidu.tieba.personCenter.c.a aVar11;
        com.baidu.tieba.personCenter.c.a aVar12;
        com.baidu.tieba.personCenter.c.a aVar13;
        com.baidu.tieba.personCenter.c.a aVar14;
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.g.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.g.i) customResponsedMessage.getData()).fhU;
            if (sparseArray.size() > 0) {
                i.a aVar15 = sparseArray.get(4);
                i.a aVar16 = sparseArray.get(3);
                i.a aVar17 = sparseArray.get(1);
                i.a aVar18 = sparseArray.get(7);
                aVar = this.eDF.eDE;
                if (aVar != null) {
                    aVar2 = this.eDF.eDE;
                    if (aVar2.eDe != null) {
                        aVar13 = this.eDF.eDE;
                        if (aVar13.eDe.bJp != null && aVar15 != null) {
                            aVar14 = this.eDF.eDE;
                            aVar14.eDe.bJp.putBoolean("person_center_item_red_tip_show", aVar15.fhV);
                            z = true;
                            if (aVar16 != null) {
                                aVar10 = this.eDF.eDE;
                                if (aVar10.eDd != null) {
                                    aVar11 = this.eDF.eDE;
                                    if (aVar11.eDd.bJp != null) {
                                        aVar12 = this.eDF.eDE;
                                        aVar12.eDd.bJp.putBoolean("person_center_item_red_tip_show", aVar16.fhV);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar17 != null) {
                                aVar7 = this.eDF.eDE;
                                if (aVar7.eDb != null) {
                                    aVar8 = this.eDF.eDE;
                                    if (aVar8.eDb.bJp != null) {
                                        aVar9 = this.eDF.eDE;
                                        aVar9.eDb.bJp.putBoolean("person_center_item_red_tip_show", aVar17.fhV);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar18 != null) {
                                aVar4 = this.eDF.eDE;
                                if (aVar4.eDf != null) {
                                    aVar5 = this.eDF.eDE;
                                    if (aVar5.eDf.bJp != null) {
                                        aVar6 = this.eDF.eDE;
                                        aVar6.eDf.bJp.putBoolean("person_center_item_red_tip_show", aVar18.fhV);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.eDF.fMg;
                                aVar3 = this.eDF.eDE;
                                bdPersonListView.setData(aVar3.amU());
                            }
                        }
                    }
                    z = false;
                    if (aVar16 != null) {
                    }
                    if (aVar17 != null) {
                    }
                    if (aVar18 != null) {
                    }
                    if (z) {
                    }
                }
                i.a aVar19 = sparseArray.get(2);
                if (aVar19 != null && this.eDF.fMf != null && this.eDF.fMf.fMH != null) {
                    this.eDF.fMf.fMH.lN(aVar19.fhV);
                }
                wVar = this.eDF.fMe;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar20 = sparseArray.get(5);
                    if (aVar20 != null) {
                        wVar3 = this.eDF.fMe;
                        wVar3.H(5, aVar20.fhV);
                    }
                    i.a aVar21 = sparseArray.get(6);
                    if (aVar21 != null) {
                        wVar2 = this.eDF.fMe;
                        wVar2.H(6, aVar21.fhV);
                    }
                }
            }
        }
    }
}
