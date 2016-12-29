package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eis = newSubPbActivity;
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
                bcVar = this.eis.eib;
                if (bcVar.aNr() != null) {
                    bcVar2 = this.eis.eib;
                    if (bcVar2.aNr().aIF() != null) {
                        bcVar3 = this.eis.eib;
                        if (bcVar3.aNr().aIF().getAuthor() != null) {
                            bcVar4 = this.eis.eib;
                            if (currentAccount.equals(bcVar4.aNr().aIF().getAuthor().getUserId())) {
                                bcVar5 = this.eis.eib;
                                if (bcVar5.aNr().aIF().getAuthor().getPendantData() != null) {
                                    bcVar6 = this.eis.eib;
                                    bcVar6.aNr().aIF().getAuthor().getPendantData().cs(kVar.pS());
                                    bcVar7 = this.eis.eib;
                                    bcVar7.aNr().aIF().getAuthor().getPendantData().O(kVar.Cb());
                                    aoVar = this.eis.eid;
                                    bcVar8 = this.eis.eib;
                                    com.baidu.tieba.tbadkCore.data.q aIF = bcVar8.aNr().aIF();
                                    bcVar9 = this.eis.eib;
                                    boolean asx = bcVar9.aNr().asx();
                                    bcVar10 = this.eis.eib;
                                    boolean nz = bcVar10.aNr().nz();
                                    bcVar11 = this.eis.eib;
                                    int aIu = bcVar11.aIu();
                                    bcVar12 = this.eis.eib;
                                    aoVar.a(aIF, asx, nz, aIu, bcVar12.aNH() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
