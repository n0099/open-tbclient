package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ar;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fm fmVar;
        PbModel pbModel4;
        fm fmVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
            com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
            ar.a aVar = new ar.a();
            aVar.giftId = abVar.id;
            aVar.giftName = abVar.name;
            aVar.Vz = abVar.Vz;
            pbModel = this.ehy.efE;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.ehy.efE;
                if (pbModel2.aKa() != null) {
                    pbModel4 = this.ehy.efE;
                    if (pbModel4.aKa().getUserIdLong() == abVar.toUserId) {
                        fmVar2 = this.ehy.egt;
                        int i = abVar.sendCount;
                        pbModel5 = this.ehy.efE;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.ehy.efE;
                        boolean aJT = pbModel6.aJT();
                        pbModel7 = this.ehy.efE;
                        fmVar2.a(i, pbData2, aJT, pbModel7.aKj());
                    }
                }
                if (pbData.aHI() != null && pbData.aHI().size() >= 1 && pbData.aHI().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aHI().get(0).getId(), 0L);
                    pbModel3 = this.ehy.efE;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.ar bgT = pbData.aHI().get(0).bgT();
                        if (bgT == null) {
                            bgT = new com.baidu.tbadk.core.data.ar();
                        }
                        ArrayList<ar.a> qA = bgT.qA();
                        if (qA == null) {
                            qA = new ArrayList<>();
                        }
                        qA.add(0, aVar);
                        bgT.bL(abVar.sendCount + bgT.qz());
                        bgT.g(qA);
                        pbData.aHI().get(0).a(bgT);
                        fmVar = this.ehy.egt;
                        fmVar.aLy().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
