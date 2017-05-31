package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.j.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ ac eOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ac acVar, int i) {
        super(i);
        this.eOh = acVar;
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
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.view.q qVar;
        com.baidu.tieba.view.q qVar2;
        com.baidu.tieba.view.q qVar3;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        boolean z;
        com.baidu.tieba.personCenter.a.a aVar3;
        com.baidu.tieba.personCenter.a.a aVar4;
        com.baidu.tieba.personPolymeric.c.a aVar5;
        com.baidu.tieba.personCenter.a.a aVar6;
        com.baidu.tieba.personPolymeric.c.a aVar7;
        com.baidu.tieba.personPolymeric.c.a aVar8;
        com.baidu.tieba.personPolymeric.c.a aVar9;
        com.baidu.tieba.personPolymeric.c.a aVar10;
        com.baidu.tieba.personPolymeric.c.a aVar11;
        com.baidu.tieba.personPolymeric.c.a aVar12;
        com.baidu.tieba.personPolymeric.c.a aVar13;
        com.baidu.tieba.personPolymeric.c.a aVar14;
        com.baidu.tieba.personPolymeric.c.a aVar15;
        com.baidu.tieba.personPolymeric.c.a aVar16;
        com.baidu.tieba.personPolymeric.c.a aVar17;
        com.baidu.tieba.personPolymeric.c.a aVar18;
        com.baidu.tieba.personPolymeric.c.a aVar19;
        com.baidu.tieba.personPolymeric.c.a aVar20;
        com.baidu.tieba.personPolymeric.c.a aVar21;
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.j.i) customResponsedMessage.getData()).flK;
            if (sparseArray.size() > 0) {
                i.a aVar22 = sparseArray.get(2);
                if (aVar22 != null && this.eOh.fQD != null && this.eOh.fQD.fRa != null) {
                    this.eOh.fQD.fRa.dm(aVar22.dBr);
                }
                i.a aVar23 = sparseArray.get(4);
                i.a aVar24 = sparseArray.get(3);
                i.a aVar25 = sparseArray.get(1);
                i.a aVar26 = sparseArray.get(7);
                i.a aVar27 = sparseArray.get(8);
                aVar = this.eOh.bxe;
                if (aVar != null) {
                    aVar2 = this.eOh.bxe;
                    if (aVar2.eMg != null) {
                        aVar20 = this.eOh.bxe;
                        if (aVar20.eMg.bOj != null && aVar23 != null) {
                            aVar21 = this.eOh.bxe;
                            aVar21.eMg.bOj.putBoolean("person_center_item_red_tip_show", aVar23.dBr);
                            z = true;
                            if (aVar24 != null) {
                                aVar17 = this.eOh.bxe;
                                if (aVar17.eMf != null) {
                                    aVar18 = this.eOh.bxe;
                                    if (aVar18.eMf.bOj != null) {
                                        aVar19 = this.eOh.bxe;
                                        aVar19.eMf.bOj.putBoolean("person_center_item_red_tip_show", aVar24.dBr);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar25 != null) {
                                aVar14 = this.eOh.bxe;
                                if (aVar14.eMd != null) {
                                    aVar15 = this.eOh.bxe;
                                    if (aVar15.eMd.bOj != null) {
                                        aVar16 = this.eOh.bxe;
                                        aVar16.eMd.bOj.putBoolean("person_center_item_red_tip_show", aVar25.dBr);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar26 != null) {
                                aVar11 = this.eOh.bxe;
                                if (aVar11.eMh != null) {
                                    aVar12 = this.eOh.bxe;
                                    if (aVar12.eMh.bOj != null) {
                                        aVar13 = this.eOh.bxe;
                                        aVar13.eMh.bOj.putBoolean("person_center_item_red_tip_show", aVar26.dBr);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar27 != null) {
                                aVar7 = this.eOh.bxe;
                                if (aVar7.eMi != null) {
                                    aVar8 = this.eOh.bxe;
                                    if (aVar8.eMi.bOj != null) {
                                        aVar9 = this.eOh.bxe;
                                        aVar9.eMi.bOj.putBoolean("person_center_item_red_tip_show", aVar27.dBr);
                                        aVar10 = this.eOh.bxe;
                                        aVar10.eMi.bOj.putString("person_center_item_txt", String.valueOf(aVar27.mNum));
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                aVar3 = this.eOh.eOd;
                                if (aVar3 != null) {
                                    aVar4 = this.eOh.eOd;
                                    aVar5 = this.eOh.bxe;
                                    aVar4.setData(aVar5.aRq());
                                    aVar6 = this.eOh.eOd;
                                    aVar6.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                    z = false;
                    if (aVar24 != null) {
                    }
                    if (aVar25 != null) {
                    }
                    if (aVar26 != null) {
                    }
                    if (aVar27 != null) {
                    }
                    if (z) {
                    }
                }
                qVar = this.eOh.fQB;
                if (qVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar28 = sparseArray.get(5);
                    if (aVar28 != null) {
                        qVar3 = this.eOh.fQB;
                        qVar3.l(5, aVar28.dBr);
                    }
                    i.a aVar29 = sparseArray.get(6);
                    if (aVar29 != null) {
                        qVar2 = this.eOh.fQB;
                        qVar2.l(6, aVar29.dBr);
                    }
                }
            }
        }
    }
}
