package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        PbModel pbModel2;
        ez ezVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            pbModel = this.eiV.ehh;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            ezVar = this.eiV.ehV;
            if (ezVar != null) {
                pbModel2 = this.eiV.ehh;
                if (pbModel2 != null) {
                    ezVar5 = this.eiV.ehV;
                    pbModel3 = this.eiV.ehh;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.eiV.ehh;
                    boolean aLY = pbModel4.aLY();
                    pbModel5 = this.eiV.ehh;
                    ezVar5.d(pbData, aLY, pbModel5.aMo());
                }
            }
            ezVar2 = this.eiV.ehV;
            if (ezVar2 != null) {
                ezVar3 = this.eiV.ehV;
                if (ezVar3.aNE() != null) {
                    ezVar4 = this.eiV.ehV;
                    ezVar4.aNE().notifyDataSetChanged();
                }
            }
        }
    }
}
