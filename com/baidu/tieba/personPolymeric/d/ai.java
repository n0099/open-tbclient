package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.h.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ ab eFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ab abVar, int i) {
        super(i);
        this.eFx = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0160  */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.view.z zVar;
        com.baidu.tieba.view.z zVar2;
        com.baidu.tieba.view.z zVar3;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        boolean z;
        com.baidu.tieba.personCenter.a.a aVar;
        com.baidu.tieba.personCenter.a.a aVar2;
        com.baidu.tieba.personPolymeric.c.n nVar3;
        com.baidu.tieba.personCenter.a.a aVar3;
        com.baidu.tieba.personPolymeric.c.n nVar4;
        com.baidu.tieba.personPolymeric.c.n nVar5;
        com.baidu.tieba.personPolymeric.c.n nVar6;
        com.baidu.tieba.personPolymeric.c.n nVar7;
        com.baidu.tieba.personPolymeric.c.n nVar8;
        com.baidu.tieba.personPolymeric.c.n nVar9;
        com.baidu.tieba.personPolymeric.c.n nVar10;
        com.baidu.tieba.personPolymeric.c.n nVar11;
        com.baidu.tieba.personPolymeric.c.n nVar12;
        com.baidu.tieba.personPolymeric.c.n nVar13;
        com.baidu.tieba.personPolymeric.c.n nVar14;
        com.baidu.tieba.personPolymeric.c.n nVar15;
        com.baidu.tieba.personPolymeric.c.n nVar16;
        com.baidu.tieba.personPolymeric.c.n nVar17;
        com.baidu.tieba.personPolymeric.c.n nVar18;
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.h.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.h.i) customResponsedMessage.getData()).fdR;
            if (sparseArray.size() > 0) {
                i.a aVar4 = sparseArray.get(2);
                if (aVar4 != null && this.eFx.fIK != null && this.eFx.fIK.fJt != null) {
                    this.eFx.fIK.fJt.lv(aVar4.fdS);
                }
                i.a aVar5 = sparseArray.get(4);
                i.a aVar6 = sparseArray.get(3);
                i.a aVar7 = sparseArray.get(1);
                i.a aVar8 = sparseArray.get(7);
                i.a aVar9 = sparseArray.get(8);
                nVar = this.eFx.eCp;
                if (nVar != null) {
                    nVar2 = this.eFx.eCp;
                    if (nVar2.eDP != null) {
                        nVar17 = this.eFx.eCp;
                        if (nVar17.eDP.bIv != null && aVar5 != null) {
                            nVar18 = this.eFx.eCp;
                            nVar18.eDP.bIv.putBoolean("person_center_item_red_tip_show", aVar5.fdS);
                            z = true;
                            if (aVar6 != null) {
                                nVar14 = this.eFx.eCp;
                                if (nVar14.eDO != null) {
                                    nVar15 = this.eFx.eCp;
                                    if (nVar15.eDO.bIv != null) {
                                        nVar16 = this.eFx.eCp;
                                        nVar16.eDO.bIv.putBoolean("person_center_item_red_tip_show", aVar6.fdS);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar7 != null) {
                                nVar11 = this.eFx.eCp;
                                if (nVar11.eDM != null) {
                                    nVar12 = this.eFx.eCp;
                                    if (nVar12.eDM.bIv != null) {
                                        nVar13 = this.eFx.eCp;
                                        nVar13.eDM.bIv.putBoolean("person_center_item_red_tip_show", aVar7.fdS);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar8 != null) {
                                nVar8 = this.eFx.eCp;
                                if (nVar8.eDQ != null) {
                                    nVar9 = this.eFx.eCp;
                                    if (nVar9.eDQ.bIv != null) {
                                        nVar10 = this.eFx.eCp;
                                        nVar10.eDQ.bIv.putBoolean("person_center_item_red_tip_show", aVar8.fdS);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar9 != null) {
                                nVar4 = this.eFx.eCp;
                                if (nVar4.eDR != null) {
                                    nVar5 = this.eFx.eCp;
                                    if (nVar5.eDR.bIv != null) {
                                        nVar6 = this.eFx.eCp;
                                        nVar6.eDR.bIv.putBoolean("person_center_item_red_tip_show", aVar9.fdS);
                                        nVar7 = this.eFx.eCp;
                                        nVar7.eDR.bIv.putString("person_center_item_txt", String.valueOf(aVar9.mNum));
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                aVar = this.eFx.eFr;
                                if (aVar != null) {
                                    aVar2 = this.eFx.eFr;
                                    nVar3 = this.eFx.eCp;
                                    aVar2.setData(nVar3.aPW());
                                    aVar3 = this.eFx.eFr;
                                    aVar3.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                    z = false;
                    if (aVar6 != null) {
                    }
                    if (aVar7 != null) {
                    }
                    if (aVar8 != null) {
                    }
                    if (aVar9 != null) {
                    }
                    if (z) {
                    }
                }
                zVar = this.eFx.fII;
                if (zVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar10 = sparseArray.get(5);
                    if (aVar10 != null) {
                        zVar3 = this.eFx.fII;
                        zVar3.G(5, aVar10.fdS);
                    }
                    i.a aVar11 = sparseArray.get(6);
                    if (aVar11 != null) {
                        zVar2 = this.eFx.fII;
                        zVar2.G(6, aVar11.fdS);
                    }
                }
            }
        }
    }
}
