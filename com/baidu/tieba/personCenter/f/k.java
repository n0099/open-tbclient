package com.baidu.tieba.personCenter.f;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.h.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ g ezT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, int i) {
        super(i);
        this.ezT = gVar;
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
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.h.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.h.i) customResponsedMessage.getData()).eZG;
            if (sparseArray.size() > 0) {
                i.a aVar15 = sparseArray.get(4);
                i.a aVar16 = sparseArray.get(3);
                i.a aVar17 = sparseArray.get(1);
                i.a aVar18 = sparseArray.get(7);
                aVar = this.ezT.ezS;
                if (aVar != null) {
                    aVar2 = this.ezT.ezS;
                    if (aVar2.ezs != null) {
                        aVar13 = this.ezT.ezS;
                        if (aVar13.ezs.bzZ != null && aVar15 != null) {
                            aVar14 = this.ezT.ezS;
                            aVar14.ezs.bzZ.putBoolean("person_center_item_red_tip_show", aVar15.eZH);
                            z = true;
                            if (aVar16 != null) {
                                aVar10 = this.ezT.ezS;
                                if (aVar10.ezr != null) {
                                    aVar11 = this.ezT.ezS;
                                    if (aVar11.ezr.bzZ != null) {
                                        aVar12 = this.ezT.ezS;
                                        aVar12.ezr.bzZ.putBoolean("person_center_item_red_tip_show", aVar16.eZH);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar17 != null) {
                                aVar7 = this.ezT.ezS;
                                if (aVar7.ezp != null) {
                                    aVar8 = this.ezT.ezS;
                                    if (aVar8.ezp.bzZ != null) {
                                        aVar9 = this.ezT.ezS;
                                        aVar9.ezp.bzZ.putBoolean("person_center_item_red_tip_show", aVar17.eZH);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar18 != null) {
                                aVar4 = this.ezT.ezS;
                                if (aVar4.ezt != null) {
                                    aVar5 = this.ezT.ezS;
                                    if (aVar5.ezt.bzZ != null) {
                                        aVar6 = this.ezT.ezS;
                                        aVar6.ezt.bzZ.putBoolean("person_center_item_red_tip_show", aVar18.eZH);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bdPersonListView = this.ezT.fDA;
                                aVar3 = this.ezT.ezS;
                                bdPersonListView.setData(aVar3.amM());
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
                if (aVar19 != null && this.ezT.fDz != null && this.ezT.fDz.fEb != null) {
                    this.ezT.fDz.fEb.lB(aVar19.eZH);
                }
                wVar = this.ezT.fDy;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar20 = sparseArray.get(5);
                    if (aVar20 != null) {
                        wVar3 = this.ezT.fDy;
                        wVar3.G(5, aVar20.eZH);
                    }
                    i.a aVar21 = sparseArray.get(6);
                    if (aVar21 != null) {
                        wVar2 = this.ezT.fDy;
                        wVar2.G(6, aVar21.eZH);
                    }
                }
            }
        }
    }
}
