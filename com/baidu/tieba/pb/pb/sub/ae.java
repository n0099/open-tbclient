package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.exF = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        ag agVar;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        ax axVar11;
        ax axVar12;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                axVar = this.exF.exr;
                if (axVar.aRs() != null) {
                    axVar2 = this.exF.exr;
                    if (axVar2.aRs().aMN() != null) {
                        axVar3 = this.exF.exr;
                        if (axVar3.aRs().aMN().getAuthor() != null) {
                            axVar4 = this.exF.exr;
                            if (currentAccount.equals(axVar4.aRs().aMN().getAuthor().getUserId())) {
                                axVar5 = this.exF.exr;
                                if (axVar5.aRs().aMN().getAuthor().getPendantData() != null) {
                                    axVar6 = this.exF.exr;
                                    axVar6.aRs().aMN().getAuthor().getPendantData().cq(jVar.pO());
                                    axVar7 = this.exF.exr;
                                    axVar7.aRs().aMN().getAuthor().getPendantData().Q(jVar.Cg());
                                    agVar = this.exF.exu;
                                    axVar8 = this.exF.exr;
                                    com.baidu.tieba.tbadkCore.data.q aMN = axVar8.aRs().aMN();
                                    axVar9 = this.exF.exr;
                                    boolean awb = axVar9.aRs().awb();
                                    axVar10 = this.exF.exr;
                                    boolean nv = axVar10.aRs().nv();
                                    axVar11 = this.exF.exr;
                                    int aMz = axVar11.aMz();
                                    axVar12 = this.exF.exr;
                                    agVar.a(aMN, awb, nv, aMz, axVar12.aRI() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
