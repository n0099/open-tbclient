package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ar;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fa faVar;
        PbModel pbModel4;
        fa faVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ac)) {
            com.baidu.tbadk.core.data.ac acVar = (com.baidu.tbadk.core.data.ac) customResponsedMessage.getData();
            ar.a aVar = new ar.a();
            aVar.giftId = acVar.id;
            aVar.giftName = acVar.name;
            aVar.VP = acVar.VP;
            pbModel = this.elO.ejZ;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.elO.ejZ;
                if (pbModel2.aLB() != null) {
                    pbModel4 = this.elO.ejZ;
                    if (pbModel4.aLB().getUserIdLong() == acVar.toUserId) {
                        faVar2 = this.elO.ekM;
                        int i = acVar.sendCount;
                        pbModel5 = this.elO.ejZ;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.elO.ejZ;
                        boolean aLu = pbModel6.aLu();
                        pbModel7 = this.elO.ejZ;
                        faVar2.a(i, pbData2, aLu, pbModel7.aLK());
                    }
                }
                if (pbData.aJs() != null && pbData.aJs().size() >= 1 && pbData.aJs().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aJs().get(0).getId(), 0L);
                    pbModel3 = this.elO.ejZ;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == acVar.postId && c2 == acVar.threadId) {
                        com.baidu.tbadk.core.data.ar bhK = pbData.aJs().get(0).bhK();
                        if (bhK == null) {
                            bhK = new com.baidu.tbadk.core.data.ar();
                        }
                        ArrayList<ar.a> qT = bhK.qT();
                        if (qT == null) {
                            qT = new ArrayList<>();
                        }
                        qT.add(0, aVar);
                        bhK.bL(acVar.sendCount + bhK.qS());
                        bhK.g(qT);
                        pbData.aJs().get(0).a(bhK);
                        faVar = this.elO.ekM;
                        faVar.aMX().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
