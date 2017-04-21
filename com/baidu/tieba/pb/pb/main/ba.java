package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
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
            pbModel = this.emk.ekv;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            eyVar = this.emk.eli;
            if (eyVar != null) {
                pbModel2 = this.emk.ekv;
                if (pbModel2 != null) {
                    eyVar5 = this.emk.eli;
                    pbModel3 = this.emk.ekv;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.emk.ekv;
                    boolean aMD = pbModel4.aMD();
                    pbModel5 = this.emk.ekv;
                    eyVar5.d(pbData, aMD, pbModel5.aMU());
                }
            }
            eyVar2 = this.emk.eli;
            if (eyVar2 != null) {
                eyVar3 = this.emk.eli;
                if (eyVar3.aOh() != null) {
                    eyVar4 = this.emk.eli;
                    eyVar4.aOh().notifyDataSetChanged();
                }
            }
        }
    }
}
