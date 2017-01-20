package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.erC = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        SubPbModel subPbModel6;
        SubPbModel subPbModel7;
        ao aoVar;
        SubPbModel subPbModel8;
        SubPbModel subPbModel9;
        SubPbModel subPbModel10;
        SubPbModel subPbModel11;
        SubPbModel subPbModel12;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                subPbModel = this.erC.erl;
                if (subPbModel.aPn() != null) {
                    subPbModel2 = this.erC.erl;
                    if (subPbModel2.aPn().aKw() != null) {
                        subPbModel3 = this.erC.erl;
                        if (subPbModel3.aPn().aKw().getAuthor() != null) {
                            subPbModel4 = this.erC.erl;
                            if (currentAccount.equals(subPbModel4.aPn().aKw().getAuthor().getUserId())) {
                                subPbModel5 = this.erC.erl;
                                if (subPbModel5.aPn().aKw().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.erC.erl;
                                    subPbModel6.aPn().aKw().getAuthor().getPendantData().cq(jVar.pL());
                                    subPbModel7 = this.erC.erl;
                                    subPbModel7.aPn().aKw().getAuthor().getPendantData().N(jVar.BX());
                                    aoVar = this.erC.ern;
                                    subPbModel8 = this.erC.erl;
                                    com.baidu.tieba.tbadkCore.data.p aKw = subPbModel8.aPn().aKw();
                                    subPbModel9 = this.erC.erl;
                                    boolean atD = subPbModel9.aPn().atD();
                                    subPbModel10 = this.erC.erl;
                                    boolean nt = subPbModel10.aPn().nt();
                                    subPbModel11 = this.erC.erl;
                                    int aKj = subPbModel11.aKj();
                                    subPbModel12 = this.erC.erl;
                                    aoVar.a(aKw, atD, nt, aKj, subPbModel12.aPD() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
