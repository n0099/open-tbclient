package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eEs = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        bc bcVar7;
        ao aoVar;
        bc bcVar8;
        bc bcVar9;
        bc bcVar10;
        bc bcVar11;
        bc bcVar12;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData();
                bcVar = this.eEs.eEb;
                if (bcVar.aTA() != null) {
                    bcVar2 = this.eEs.eEb;
                    if (bcVar2.aTA().aOG() != null) {
                        bcVar3 = this.eEs.eEb;
                        if (bcVar3.aTA().aOG().getAuthor() != null) {
                            bcVar4 = this.eEs.eEb;
                            if (currentAccount.equals(bcVar4.aTA().aOG().getAuthor().getUserId())) {
                                bcVar5 = this.eEs.eEb;
                                if (bcVar5.aTA().aOG().getAuthor().getPendantData() != null) {
                                    bcVar6 = this.eEs.eEb;
                                    bcVar6.aTA().aOG().getAuthor().getPendantData().cs(kVar.pR());
                                    bcVar7 = this.eEs.eEb;
                                    bcVar7.aTA().aOG().getAuthor().getPendantData().P(kVar.Co());
                                    aoVar = this.eEs.eEd;
                                    bcVar8 = this.eEs.eEb;
                                    com.baidu.tieba.tbadkCore.data.q aOG = bcVar8.aTA().aOG();
                                    bcVar9 = this.eEs.eEb;
                                    boolean axY = bcVar9.aTA().axY();
                                    bcVar10 = this.eEs.eEb;
                                    boolean nz = bcVar10.aTA().nz();
                                    bcVar11 = this.eEs.eEb;
                                    int aOt = bcVar11.aOt();
                                    bcVar12 = this.eEs.eEb;
                                    aoVar.a(aOG, axY, nz, aOt, bcVar12.aTQ() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
