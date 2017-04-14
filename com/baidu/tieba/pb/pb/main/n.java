package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ey eyVar;
        PbModel pbModel4;
        ey eyVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
            com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
            aq.a aVar = new aq.a();
            aVar.giftId = abVar.id;
            aVar.giftName = abVar.name;
            aVar.We = abVar.We;
            pbModel = this.ejU.eif;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.ejU.eif;
                if (pbModel2.aLK() != null) {
                    pbModel4 = this.ejU.eif;
                    if (pbModel4.aLK().getUserIdLong() == abVar.toUserId) {
                        eyVar2 = this.ejU.eiS;
                        int i = abVar.sendCount;
                        pbModel5 = this.ejU.eif;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.ejU.eif;
                        boolean aLC = pbModel6.aLC();
                        pbModel7 = this.ejU.eif;
                        eyVar2.a(i, pbData2, aLC, pbModel7.aLT());
                    }
                }
                if (pbData.aJz() != null && pbData.aJz().size() >= 1 && pbData.aJz().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aJz().get(0).getId(), 0L);
                    pbModel3 = this.ejU.eif;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.aq biv = pbData.aJz().get(0).biv();
                        if (biv == null) {
                            biv = new com.baidu.tbadk.core.data.aq();
                        }
                        ArrayList<aq.a> rq = biv.rq();
                        if (rq == null) {
                            rq = new ArrayList<>();
                        }
                        rq.add(0, aVar);
                        biv.bO(abVar.sendCount + biv.rp());
                        biv.g(rq);
                        pbData.aJz().get(0).a(biv);
                        eyVar = this.ejU.eiS;
                        eyVar.aNg().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
