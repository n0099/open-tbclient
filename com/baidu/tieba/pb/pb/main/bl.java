package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bl extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        PbModel pbModel2;
        fx fxVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            pbModel = this.enc.ele;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            fxVar = this.enc.elU;
            if (fxVar != null) {
                pbModel2 = this.enc.ele;
                if (pbModel2 != null) {
                    fxVar5 = this.enc.elU;
                    pbModel3 = this.enc.ele;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.enc.ele;
                    boolean aKN = pbModel4.aKN();
                    pbModel5 = this.enc.ele;
                    fxVar5.d(pbData, aKN, pbModel5.aLd());
                }
            }
            fxVar2 = this.enc.elU;
            if (fxVar2 != null) {
                fxVar3 = this.enc.elU;
                if (fxVar3.aMu() != null) {
                    fxVar4 = this.enc.elU;
                    fxVar4.aMu().notifyDataSetChanged();
                }
            }
        }
    }
}
