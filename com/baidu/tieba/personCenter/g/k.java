package com.baidu.tieba.personCenter.g;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.f.h;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g eGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.eGb = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
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
        if (customResponsedMessage.getCmd() == 2001514 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.f.h)) {
            SparseArray<h.a> sparseArray = ((com.baidu.tieba.f.h) customResponsedMessage.getData()).feY;
            if (sparseArray.size() > 0) {
                h.a aVar12 = sparseArray.get(4);
                h.a aVar13 = sparseArray.get(3);
                h.a aVar14 = sparseArray.get(1);
                aVar = this.eGb.eGa;
                if (aVar != null) {
                    aVar2 = this.eGb.eGa;
                    if (aVar2.eFA != null) {
                        aVar10 = this.eGb.eGa;
                        if (aVar10.eFA.bJr != null && aVar12 != null) {
                            aVar11 = this.eGb.eGa;
                            aVar11.eFA.bJr.putBoolean("person_center_item_red_tip_show", aVar12.aPh);
                            z = true;
                            if (aVar13 != null) {
                                aVar7 = this.eGb.eGa;
                                if (aVar7.eFz != null) {
                                    aVar8 = this.eGb.eGa;
                                    if (aVar8.eFz.bJr != null) {
                                        aVar9 = this.eGb.eGa;
                                        aVar9.eFz.bJr.putBoolean("person_center_item_red_tip_show", aVar13.aPh);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar14 != null) {
                                aVar4 = this.eGb.eGa;
                                if (aVar4.eFy != null) {
                                    aVar5 = this.eGb.eGa;
                                    if (aVar5.eFy.bJr != null) {
                                        aVar6 = this.eGb.eGa;
                                        aVar6.eFy.bJr.putBoolean("person_center_item_red_tip_show", aVar14.aPh);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.eGb.fYs;
                                aVar3 = this.eGb.eGa;
                                bdPersonListView.setData(aVar3.aph());
                            }
                        }
                    }
                    z = false;
                    if (aVar13 != null) {
                    }
                    if (aVar14 != null) {
                    }
                    if (z) {
                    }
                }
                h.a aVar15 = sparseArray.get(2);
                if (aVar15 != null && this.eGb.fYr != null && this.eGb.fYr.fYT != null) {
                    this.eGb.fYr.fYT.lC(aVar15.aPh);
                }
                wVar = this.eGb.fYq;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    h.a aVar16 = sparseArray.get(5);
                    if (aVar16 != null) {
                        wVar3 = this.eGb.fYq;
                        wVar3.T(5, aVar16.aPh);
                    }
                    h.a aVar17 = sparseArray.get(6);
                    if (aVar17 != null) {
                        wVar2 = this.eGb.fYq;
                        wVar2.T(6, aVar17.aPh);
                    }
                }
            }
        }
    }
}
