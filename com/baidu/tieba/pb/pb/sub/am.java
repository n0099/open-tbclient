package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.evm = newSubPbActivity;
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
                subPbModel = this.evm.euV;
                if (subPbModel.aPO() != null) {
                    subPbModel2 = this.evm.euV;
                    if (subPbModel2.aPO().aKW() != null) {
                        subPbModel3 = this.evm.euV;
                        if (subPbModel3.aPO().aKW().getAuthor() != null) {
                            subPbModel4 = this.evm.euV;
                            if (currentAccount.equals(subPbModel4.aPO().aKW().getAuthor().getUserId())) {
                                subPbModel5 = this.evm.euV;
                                if (subPbModel5.aPO().aKW().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.evm.euV;
                                    subPbModel6.aPO().aKW().getAuthor().getPendantData().cr(jVar.qB());
                                    subPbModel7 = this.evm.euV;
                                    subPbModel7.aPO().aKW().getAuthor().getPendantData().N(jVar.CO());
                                    aoVar = this.evm.euX;
                                    subPbModel8 = this.evm.euV;
                                    PostData aKW = subPbModel8.aPO().aKW();
                                    subPbModel9 = this.evm.euV;
                                    boolean atS = subPbModel9.aPO().atS();
                                    subPbModel10 = this.evm.euV;
                                    boolean oe = subPbModel10.aPO().oe();
                                    subPbModel11 = this.evm.euV;
                                    int aKI = subPbModel11.aKI();
                                    subPbModel12 = this.evm.euV;
                                    aoVar.a(aKW, atS, oe, aKI, subPbModel12.aQe() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
