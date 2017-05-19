package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eqU = newSubPbActivity;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                com.baidu.tbadk.data.i iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                subPbModel = this.eqU.eqD;
                if (subPbModel.aNe() != null) {
                    subPbModel2 = this.eqU.eqD;
                    if (subPbModel2.aNe().aIr() != null) {
                        subPbModel3 = this.eqU.eqD;
                        if (subPbModel3.aNe().aIr().getAuthor() != null) {
                            subPbModel4 = this.eqU.eqD;
                            if (currentAccount.equals(subPbModel4.aNe().aIr().getAuthor().getUserId())) {
                                subPbModel5 = this.eqU.eqD;
                                if (subPbModel5.aNe().aIr().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.eqU.eqD;
                                    subPbModel6.aNe().aIr().getAuthor().getPendantData().cr(iVar.pT());
                                    subPbModel7 = this.eqU.eqD;
                                    subPbModel7.aNe().aIr().getAuthor().getPendantData().O(iVar.BT());
                                    aoVar = this.eqU.eqF;
                                    subPbModel8 = this.eqU.eqD;
                                    PostData aIr = subPbModel8.aNe().aIr();
                                    subPbModel9 = this.eqU.eqD;
                                    boolean aqM = subPbModel9.aNe().aqM();
                                    subPbModel10 = this.eqU.eqD;
                                    boolean nL = subPbModel10.aNe().nL();
                                    subPbModel11 = this.eqU.eqD;
                                    int aHR = subPbModel11.aHR();
                                    subPbModel12 = this.eqU.eqD;
                                    aoVar.a(aIr, aqM, nL, aHR, subPbModel12.aNu() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
