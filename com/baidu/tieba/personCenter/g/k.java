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
    final /* synthetic */ g eMA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.eMA = gVar;
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
            SparseArray<h.a> sparseArray = ((com.baidu.tieba.f.h) customResponsedMessage.getData()).fmq;
            if (sparseArray.size() > 0) {
                h.a aVar12 = sparseArray.get(4);
                h.a aVar13 = sparseArray.get(3);
                h.a aVar14 = sparseArray.get(1);
                aVar = this.eMA.eMz;
                if (aVar != null) {
                    aVar2 = this.eMA.eMz;
                    if (aVar2.eLZ != null) {
                        aVar10 = this.eMA.eMz;
                        if (aVar10.eLZ.bMk != null && aVar12 != null) {
                            aVar11 = this.eMA.eMz;
                            aVar11.eLZ.bMk.putBoolean("person_center_item_red_tip_show", aVar12.aRn);
                            z = true;
                            if (aVar13 != null) {
                                aVar7 = this.eMA.eMz;
                                if (aVar7.eLY != null) {
                                    aVar8 = this.eMA.eMz;
                                    if (aVar8.eLY.bMk != null) {
                                        aVar9 = this.eMA.eMz;
                                        aVar9.eLY.bMk.putBoolean("person_center_item_red_tip_show", aVar13.aRn);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar14 != null) {
                                aVar4 = this.eMA.eMz;
                                if (aVar4.eLX != null) {
                                    aVar5 = this.eMA.eMz;
                                    if (aVar5.eLX.bMk != null) {
                                        aVar6 = this.eMA.eMz;
                                        aVar6.eLX.bMk.putBoolean("person_center_item_red_tip_show", aVar14.aRn);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.eMA.gfN;
                                aVar3 = this.eMA.eMz;
                                bdPersonListView.setData(aVar3.ard());
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
                if (aVar15 != null && this.eMA.gfM != null && this.eMA.gfM.ggp != null) {
                    this.eMA.gfM.ggp.mb(aVar15.aRn);
                }
                wVar = this.eMA.gfL;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    h.a aVar16 = sparseArray.get(5);
                    if (aVar16 != null) {
                        wVar3 = this.eMA.gfL;
                        wVar3.W(5, aVar16.aRn);
                    }
                    h.a aVar17 = sparseArray.get(6);
                    if (aVar17 != null) {
                        wVar2 = this.eMA.gfL;
                        wVar2.W(6, aVar17.aRn);
                    }
                }
            }
        }
    }
}
