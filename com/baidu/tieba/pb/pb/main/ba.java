package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        fa faVar;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        PbModel pbModel2;
        fa faVar5;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            pbModel = this.elO.ejZ;
            pbModel.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            faVar = this.elO.ekM;
            if (faVar != null) {
                pbModel2 = this.elO.ejZ;
                if (pbModel2 != null) {
                    faVar5 = this.elO.ekM;
                    pbModel3 = this.elO.ejZ;
                    com.baidu.tieba.pb.data.f pbData = pbModel3.getPbData();
                    pbModel4 = this.elO.ejZ;
                    boolean aLu = pbModel4.aLu();
                    pbModel5 = this.elO.ejZ;
                    faVar5.d(pbData, aLu, pbModel5.aLK());
                }
            }
            faVar2 = this.elO.ekM;
            if (faVar2 != null) {
                faVar3 = this.elO.ekM;
                if (faVar3.aMX() != null) {
                    faVar4 = this.elO.ekM;
                    faVar4.aMX().notifyDataSetChanged();
                }
            }
        }
    }
}
