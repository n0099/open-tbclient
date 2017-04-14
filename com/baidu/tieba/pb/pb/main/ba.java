package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        PbModel pbModel2;
        ey eyVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            pbModel = this.ejU.eif;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            eyVar = this.ejU.eiS;
            if (eyVar != null) {
                pbModel2 = this.ejU.eif;
                if (pbModel2 != null) {
                    eyVar5 = this.ejU.eiS;
                    pbModel3 = this.ejU.eif;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.ejU.eif;
                    boolean aLC = pbModel4.aLC();
                    pbModel5 = this.ejU.eif;
                    eyVar5.d(pbData, aLC, pbModel5.aLT());
                }
            }
            eyVar2 = this.ejU.eiS;
            if (eyVar2 != null) {
                eyVar3 = this.ejU.eiS;
                if (eyVar3.aNg() != null) {
                    eyVar4 = this.ejU.eiS;
                    eyVar4.aNg().notifyDataSetChanged();
                }
            }
        }
    }
}
