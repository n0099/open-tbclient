package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ ac eYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ac acVar, int i) {
        super(i);
        this.eYx = acVar;
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
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.j)) {
            SparseArray<j.a> sparseArray = ((com.baidu.tieba.j.j) customResponsedMessage.getData()).fvY;
            if (sparseArray.size() > 0) {
                j.a aVar22 = sparseArray.get(2);
                if (aVar22 != null && this.eYx.gau != null && this.eYx.gau.gbb != null) {
                    this.eYx.gau.gbb.mo(aVar22.dJL);
                }
                j.a aVar23 = sparseArray.get(4);
                j.a aVar24 = sparseArray.get(3);
                j.a aVar25 = sparseArray.get(1);
                j.a aVar26 = sparseArray.get(7);
                j.a aVar27 = sparseArray.get(8);
                aVar = this.eYx.eVl;
                if (aVar != null) {
                    aVar2 = this.eYx.eVl;
                    if (aVar2.eWo != null) {
                        aVar20 = this.eYx.eVl;
                        if (aVar20.eWo.bVe != null && aVar23 != null) {
                            aVar21 = this.eYx.eVl;
                            aVar21.eWo.bVe.putBoolean("person_center_item_red_tip_show", aVar23.dJL);
                            z = true;
                            if (aVar24 != null) {
                                aVar17 = this.eYx.eVl;
                                if (aVar17.eWn != null) {
                                    aVar18 = this.eYx.eVl;
                                    if (aVar18.eWn.bVe != null) {
                                        aVar19 = this.eYx.eVl;
                                        aVar19.eWn.bVe.putBoolean("person_center_item_red_tip_show", aVar24.dJL);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar25 != null) {
                                aVar14 = this.eYx.eVl;
                                if (aVar14.eWl != null) {
                                    aVar15 = this.eYx.eVl;
                                    if (aVar15.eWl.bVe != null) {
                                        aVar16 = this.eYx.eVl;
                                        aVar16.eWl.bVe.putBoolean("person_center_item_red_tip_show", aVar25.dJL);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar26 != null) {
                                aVar11 = this.eYx.eVl;
                                if (aVar11.eWp != null) {
                                    aVar12 = this.eYx.eVl;
                                    if (aVar12.eWp.bVe != null) {
                                        aVar13 = this.eYx.eVl;
                                        aVar13.eWp.bVe.putBoolean("person_center_item_red_tip_show", aVar26.dJL);
                                        z = true;
                                    }
                                }
                            }
                            if (aVar27 != null) {
                                aVar7 = this.eYx.eVl;
                                if (aVar7.eWq != null) {
                                    aVar8 = this.eYx.eVl;
                                    if (aVar8.eWq.bVe != null) {
                                        aVar9 = this.eYx.eVl;
                                        aVar9.eWq.bVe.putBoolean("person_center_item_red_tip_show", aVar27.dJL);
                                        aVar10 = this.eYx.eVl;
                                        aVar10.eWq.bVe.putString("person_center_item_txt", String.valueOf(aVar27.mNum));
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                aVar3 = this.eYx.eYr;
                                if (aVar3 != null) {
                                    aVar4 = this.eYx.eYr;
                                    aVar5 = this.eYx.eVl;
                                    aVar4.setData(aVar5.aVz());
                                    aVar6 = this.eYx.eYr;
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
                qVar = this.eYx.gas;
                if (qVar instanceof com.baidu.tieba.view.j) {
                    j.a aVar28 = sparseArray.get(5);
                    if (aVar28 != null) {
                        qVar3 = this.eYx.gas;
                        qVar3.l(5, aVar28.dJL);
                    }
                    j.a aVar29 = sparseArray.get(6);
                    if (aVar29 != null) {
                        qVar2 = this.eYx.gas;
                        qVar2.l(6, aVar29.dJL);
                    }
                }
            }
        }
    }
}
