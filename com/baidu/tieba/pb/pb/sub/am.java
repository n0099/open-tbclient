package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eye = newSubPbActivity;
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
                subPbModel = this.eye.exN;
                if (subPbModel.aOn() != null) {
                    subPbModel2 = this.eye.exN;
                    if (subPbModel2.aOn().aJj() != null) {
                        subPbModel3 = this.eye.exN;
                        if (subPbModel3.aOn().aJj().getAuthor() != null) {
                            subPbModel4 = this.eye.exN;
                            if (currentAccount.equals(subPbModel4.aOn().aJj().getAuthor().getUserId())) {
                                subPbModel5 = this.eye.exN;
                                if (subPbModel5.aOn().aJj().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.eye.exN;
                                    subPbModel6.aOn().aJj().getAuthor().getPendantData().cq(jVar.pL());
                                    subPbModel7 = this.eye.exN;
                                    subPbModel7.aOn().aJj().getAuthor().getPendantData().O(jVar.BN());
                                    aoVar = this.eye.exP;
                                    subPbModel8 = this.eye.exN;
                                    PostData aJj = subPbModel8.aOn().aJj();
                                    subPbModel9 = this.eye.exN;
                                    boolean arL = subPbModel9.aOn().arL();
                                    subPbModel10 = this.eye.exN;
                                    boolean nD = subPbModel10.aOn().nD();
                                    subPbModel11 = this.eye.exN;
                                    int aIM = subPbModel11.aIM();
                                    subPbModel12 = this.eye.exN;
                                    aoVar.a(aJj, arL, nD, aIM, subPbModel12.aOD() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
