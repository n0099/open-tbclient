package com.baidu.tieba.personCenter.g;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.f.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g epW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.epW = gVar;
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
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.f.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.f.i) customResponsedMessage.getData()).eQl;
            if (sparseArray.size() > 0) {
                i.a aVar15 = sparseArray.get(4);
                i.a aVar16 = sparseArray.get(3);
                i.a aVar17 = sparseArray.get(1);
                i.a aVar18 = sparseArray.get(7);
                aVar = this.epW.epV;
                if (aVar != null) {
                    aVar2 = this.epW.epV;
                    if (aVar2.epv != null) {
                        aVar13 = this.epW.epV;
                        if (aVar13.epv.bso != null && aVar15 != null) {
                            aVar14 = this.epW.epV;
                            aVar14.epv.bso.putBoolean("person_center_item_red_tip_show", aVar15.aQE);
                            z = true;
                            if (aVar16 != null) {
                                aVar10 = this.epW.epV;
                                if (aVar10.epu != null) {
                                    aVar11 = this.epW.epV;
                                    if (aVar11.epu.bso != null) {
                                        aVar12 = this.epW.epV;
                                        aVar12.epu.bso.putBoolean("person_center_item_red_tip_show", aVar16.aQE);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar17 != null) {
                                aVar7 = this.epW.epV;
                                if (aVar7.ept != null) {
                                    aVar8 = this.epW.epV;
                                    if (aVar8.ept.bso != null) {
                                        aVar9 = this.epW.epV;
                                        aVar9.ept.bso.putBoolean("person_center_item_red_tip_show", aVar17.aQE);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar18 != null) {
                                aVar4 = this.epW.epV;
                                if (aVar4.epw != null) {
                                    aVar5 = this.epW.epV;
                                    if (aVar5.epw.bso != null) {
                                        aVar6 = this.epW.epV;
                                        aVar6.epw.bso.putBoolean("person_center_item_red_tip_show", aVar18.aQE);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.epW.fuF;
                                aVar3 = this.epW.epV;
                                bdPersonListView.setData(aVar3.alF());
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
                if (aVar19 != null && this.epW.fuE != null && this.epW.fuE.fvh != null) {
                    this.epW.fuE.fvh.lp(aVar19.aQE);
                }
                wVar = this.epW.fuD;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar20 = sparseArray.get(5);
                    if (aVar20 != null) {
                        wVar3 = this.epW.fuD;
                        wVar3.G(5, aVar20.aQE);
                    }
                    i.a aVar21 = sparseArray.get(6);
                    if (aVar21 != null) {
                        wVar2 = this.epW.fuD;
                        wVar2.G(6, aVar21.aQE);
                    }
                }
            }
        }
    }
}
