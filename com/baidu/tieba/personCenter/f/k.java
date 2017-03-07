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
    final /* synthetic */ g eDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.eDs = gVar;
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
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.g.i) customResponsedMessage.getData()).feb;
            if (sparseArray.size() > 0) {
                i.a aVar15 = sparseArray.get(4);
                i.a aVar16 = sparseArray.get(3);
                i.a aVar17 = sparseArray.get(1);
                i.a aVar18 = sparseArray.get(7);
                aVar = this.eDs.eDr;
                if (aVar != null) {
                    aVar2 = this.eDs.eDr;
                    if (aVar2.eCR != null) {
                        aVar13 = this.eDs.eDr;
                        if (aVar13.eCR.bHf != null && aVar15 != null) {
                            aVar14 = this.eDs.eDr;
                            aVar14.eCR.bHf.putBoolean("person_center_item_red_tip_show", aVar15.fec);
                            z = true;
                            if (aVar16 != null) {
                                aVar10 = this.eDs.eDr;
                                if (aVar10.eCQ != null) {
                                    aVar11 = this.eDs.eDr;
                                    if (aVar11.eCQ.bHf != null) {
                                        aVar12 = this.eDs.eDr;
                                        aVar12.eCQ.bHf.putBoolean("person_center_item_red_tip_show", aVar16.fec);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar17 != null) {
                                aVar7 = this.eDs.eDr;
                                if (aVar7.eCO != null) {
                                    aVar8 = this.eDs.eDr;
                                    if (aVar8.eCO.bHf != null) {
                                        aVar9 = this.eDs.eDr;
                                        aVar9.eCO.bHf.putBoolean("person_center_item_red_tip_show", aVar17.fec);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar18 != null) {
                                aVar4 = this.eDs.eDr;
                                if (aVar4.eCS != null) {
                                    aVar5 = this.eDs.eDr;
                                    if (aVar5.eCS.bHf != null) {
                                        aVar6 = this.eDs.eDr;
                                        aVar6.eCS.bHf.putBoolean("person_center_item_red_tip_show", aVar18.fec);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.eDs.fIb;
                                aVar3 = this.eDs.eDr;
                                bdPersonListView.setData(aVar3.alZ());
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
                if (aVar19 != null && this.eDs.fIa != null && this.eDs.fIa.fIC != null) {
                    this.eDs.fIa.fIC.lA(aVar19.fec);
                }
                wVar = this.eDs.fHZ;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar20 = sparseArray.get(5);
                    if (aVar20 != null) {
                        wVar3 = this.eDs.fHZ;
                        wVar3.H(5, aVar20.fec);
                    }
                    i.a aVar21 = sparseArray.get(6);
                    if (aVar21 != null) {
                        wVar2 = this.eDs.fHZ;
                        wVar2.H(6, aVar21.fec);
                    }
                }
            }
        }
    }
}
