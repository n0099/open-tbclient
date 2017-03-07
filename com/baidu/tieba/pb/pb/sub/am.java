package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.euQ = newSubPbActivity;
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
                subPbModel = this.euQ.euz;
                if (subPbModel.aOE() != null) {
                    subPbModel2 = this.euQ.euz;
                    if (subPbModel2.aOE().aJO() != null) {
                        subPbModel3 = this.euQ.euz;
                        if (subPbModel3.aOE().aJO().getAuthor() != null) {
                            subPbModel4 = this.euQ.euz;
                            if (currentAccount.equals(subPbModel4.aOE().aJO().getAuthor().getUserId())) {
                                subPbModel5 = this.euQ.euz;
                                if (subPbModel5.aOE().aJO().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.euQ.euz;
                                    subPbModel6.aOE().aJO().getAuthor().getPendantData().ck(jVar.qd());
                                    subPbModel7 = this.euQ.euz;
                                    subPbModel7.aOE().aJO().getAuthor().getPendantData().N(jVar.Cq());
                                    aoVar = this.euQ.euB;
                                    subPbModel8 = this.euQ.euz;
                                    PostData aJO = subPbModel8.aOE().aJO();
                                    subPbModel9 = this.euQ.euz;
                                    boolean asY = subPbModel9.aOE().asY();
                                    subPbModel10 = this.euQ.euz;
                                    boolean nH = subPbModel10.aOE().nH();
                                    subPbModel11 = this.euQ.euz;
                                    int aJA = subPbModel11.aJA();
                                    subPbModel12 = this.euQ.euz;
                                    aoVar.a(aJO, asY, nH, aJA, subPbModel12.aOU() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
