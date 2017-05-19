package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bl extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        PbModel pbModel2;
        fm fmVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
            pbModel = this.ehy.efE;
            pbModel.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            fmVar = this.ehy.egt;
            if (fmVar != null) {
                pbModel2 = this.ehy.efE;
                if (pbModel2 != null) {
                    fmVar5 = this.ehy.egt;
                    pbModel3 = this.ehy.efE;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.ehy.efE;
                    boolean aJT = pbModel4.aJT();
                    pbModel5 = this.ehy.efE;
                    fmVar5.d(pbData, aJT, pbModel5.aKj());
                }
            }
            fmVar2 = this.ehy.egt;
            if (fmVar2 != null) {
                fmVar3 = this.ehy.egt;
                if (fmVar3.aLy() != null) {
                    fmVar4 = this.ehy.egt;
                    fmVar4.aLy().notifyDataSetChanged();
                }
            }
        }
    }
}
