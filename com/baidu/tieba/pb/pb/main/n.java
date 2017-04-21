package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
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
            aVar.Wg = abVar.Wg;
            pbModel = this.emk.ekv;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.emk.ekv;
                if (pbModel2.aML() != null) {
                    pbModel4 = this.emk.ekv;
                    if (pbModel4.aML().getUserIdLong() == abVar.toUserId) {
                        eyVar2 = this.emk.eli;
                        int i = abVar.sendCount;
                        pbModel5 = this.emk.ekv;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.emk.ekv;
                        boolean aMD = pbModel6.aMD();
                        pbModel7 = this.emk.ekv;
                        eyVar2.a(i, pbData2, aMD, pbModel7.aMU());
                    }
                }
                if (pbData.aKA() != null && pbData.aKA().size() >= 1 && pbData.aKA().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aKA().get(0).getId(), 0L);
                    pbModel3 = this.emk.ekv;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.aq bjw = pbData.aKA().get(0).bjw();
                        if (bjw == null) {
                            bjw = new com.baidu.tbadk.core.data.aq();
                        }
                        ArrayList<aq.a> rq = bjw.rq();
                        if (rq == null) {
                            rq = new ArrayList<>();
                        }
                        rq.add(0, aVar);
                        bjw.bO(abVar.sendCount + bjw.rp());
                        bjw.g(rq);
                        pbData.aKA().get(0).a(bjw);
                        eyVar = this.emk.eli;
                        eyVar.aOh().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
