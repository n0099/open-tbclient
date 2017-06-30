package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eHC = newSubPbActivity;
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
                subPbModel = this.eHC.eHl;
                if (subPbModel.aSm() != null) {
                    subPbModel2 = this.eHC.eHl;
                    if (subPbModel2.aSm().aNd() != null) {
                        subPbModel3 = this.eHC.eHl;
                        if (subPbModel3.aSm().aNd().getAuthor() != null) {
                            subPbModel4 = this.eHC.eHl;
                            if (currentAccount.equals(subPbModel4.aSm().aNd().getAuthor().getUserId())) {
                                subPbModel5 = this.eHC.eHl;
                                if (subPbModel5.aSm().aNd().getAuthor().getPendantData() != null) {
                                    subPbModel6 = this.eHC.eHl;
                                    subPbModel6.aSm().aNd().getAuthor().getPendantData().cw(jVar.pI());
                                    subPbModel7 = this.eHC.eHl;
                                    subPbModel7.aSm().aNd().getAuthor().getPendantData().P(jVar.Ch());
                                    aoVar = this.eHC.eHn;
                                    subPbModel8 = this.eHC.eHl;
                                    PostData aNd = subPbModel8.aSm().aNd();
                                    subPbModel9 = this.eHC.eHl;
                                    boolean avw = subPbModel9.aSm().avw();
                                    subPbModel10 = this.eHC.eHl;
                                    boolean nz = subPbModel10.aSm().nz();
                                    subPbModel11 = this.eHC.eHl;
                                    int aMG = subPbModel11.aMG();
                                    subPbModel12 = this.eHC.eHl;
                                    aoVar.a(aNd, avw, nz, aMG, subPbModel12.aSC() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
