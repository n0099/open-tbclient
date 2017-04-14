package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.esV = newSubPbActivity;
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
                subPbModel = this.esV.esE;
                if (subPbModel.aON() != null) {
                    subPbModel2 = this.esV.esE;
                    if (subPbModel2.aON().aJV() != null) {
                        subPbModel3 = this.esV.esE;
                        if (subPbModel3.aON().aJV().getAuthor() != null) {
                            subPbModel4 = this.esV.esE;
                            if (currentAccount.equals(subPbModel4.aON().aJV().getAuthor().getUserId())) {
                                subPbModel5 = this.esV.esE;
                                if (subPbModel5.aON().aJV().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.esV.esE;
                                    subPbModel6.aON().aJV().getAuthor().getPendantData().cr(jVar.qB());
                                    subPbModel7 = this.esV.esE;
                                    subPbModel7.aON().aJV().getAuthor().getPendantData().N(jVar.CO());
                                    aoVar = this.esV.esG;
                                    subPbModel8 = this.esV.esE;
                                    PostData aJV = subPbModel8.aON().aJV();
                                    subPbModel9 = this.esV.esE;
                                    boolean asR = subPbModel9.aON().asR();
                                    subPbModel10 = this.esV.esE;
                                    boolean oe = subPbModel10.aON().oe();
                                    subPbModel11 = this.esV.esE;
                                    int aJH = subPbModel11.aJH();
                                    subPbModel12 = this.esV.esE;
                                    aoVar.a(aJV, asR, oe, aJH, subPbModel12.aPd() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
