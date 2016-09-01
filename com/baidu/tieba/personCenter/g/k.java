package com.baidu.tieba.personCenter.g;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.g.h;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g eDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.eDX = gVar;
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
        if (customResponsedMessage.getCmd() == 2001514 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.g.h)) {
            SparseArray<h.a> sparseArray = ((com.baidu.tieba.g.h) customResponsedMessage.getData()).fcp;
            if (sparseArray.size() > 0) {
                h.a aVar12 = sparseArray.get(4);
                h.a aVar13 = sparseArray.get(3);
                h.a aVar14 = sparseArray.get(1);
                aVar = this.eDX.eDW;
                if (aVar != null) {
                    aVar2 = this.eDX.eDW;
                    if (aVar2.eDx != null) {
                        aVar10 = this.eDX.eDW;
                        if (aVar10.eDx.bJq != null && aVar12 != null) {
                            aVar11 = this.eDX.eDW;
                            aVar11.eDx.bJq.putBoolean("person_center_item_red_tip_show", aVar12.fcq);
                            z = true;
                            if (aVar13 != null) {
                                aVar7 = this.eDX.eDW;
                                if (aVar7.eDw != null) {
                                    aVar8 = this.eDX.eDW;
                                    if (aVar8.eDw.bJq != null) {
                                        aVar9 = this.eDX.eDW;
                                        aVar9.eDw.bJq.putBoolean("person_center_item_red_tip_show", aVar13.fcq);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar14 != null) {
                                aVar4 = this.eDX.eDW;
                                if (aVar4.eDv != null) {
                                    aVar5 = this.eDX.eDW;
                                    if (aVar5.eDv.bJq != null) {
                                        aVar6 = this.eDX.eDW;
                                        aVar6.eDv.bJq.putBoolean("person_center_item_red_tip_show", aVar14.fcq);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.eDX.fWn;
                                aVar3 = this.eDX.eDW;
                                bdPersonListView.setData(aVar3.aoT());
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
                if (aVar15 != null && this.eDX.fWm != null && this.eDX.fWm.fWO != null) {
                    this.eDX.fWm.fWO.lA(aVar15.fcq);
                }
                wVar = this.eDX.fWl;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    h.a aVar16 = sparseArray.get(5);
                    if (aVar16 != null) {
                        wVar3 = this.eDX.fWl;
                        wVar3.T(5, aVar16.fcq);
                    }
                    h.a aVar17 = sparseArray.get(6);
                    if (aVar17 != null) {
                        wVar2 = this.eDX.fWl;
                        wVar2.T(6, aVar17.fcq);
                    }
                }
            }
        }
    }
}
