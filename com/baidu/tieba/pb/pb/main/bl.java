package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bl extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        PbModel pbModel2;
        gg ggVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            pbModel = this.ewh.eue;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            ggVar = this.ewh.euU;
            if (ggVar != null) {
                pbModel2 = this.ewh.eue;
                if (pbModel2 != null) {
                    ggVar5 = this.ewh.euU;
                    pbModel3 = this.ewh.eue;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.ewh.eue;
                    boolean aOK = pbModel4.aOK();
                    pbModel5 = this.ewh.eue;
                    ggVar5.d(pbData, aOK, pbModel5.aPa());
                }
            }
            ggVar2 = this.ewh.euU;
            if (ggVar2 != null) {
                ggVar3 = this.ewh.euU;
                if (ggVar3.aQs() != null) {
                    ggVar4 = this.ewh.euU;
                    ggVar4.aQs().notifyDataSetChanged();
                }
            }
        }
    }
}
