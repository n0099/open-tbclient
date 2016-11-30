package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dj djVar;
        dj djVar2;
        dj djVar3;
        ey eyVar;
        dj djVar4;
        ey eyVar2;
        dj djVar5;
        dj djVar6;
        dj djVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
            com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
            ap.a aVar = new ap.a();
            aVar.giftId = abVar.id;
            aVar.HR = abVar.name;
            aVar.Rw = abVar.Rw;
            djVar = this.evL.euf;
            com.baidu.tieba.pb.data.h pbData = djVar.getPbData();
            if (pbData != null) {
                djVar2 = this.evL.euf;
                if (djVar2.aQv() != null) {
                    djVar4 = this.evL.euf;
                    if (djVar4.aQv().getUserIdLong() == abVar.toUserId) {
                        eyVar2 = this.evL.euP;
                        int i = abVar.sendCount;
                        djVar5 = this.evL.euf;
                        com.baidu.tieba.pb.data.h pbData2 = djVar5.getPbData();
                        djVar6 = this.evL.euf;
                        boolean aQp = djVar6.aQp();
                        djVar7 = this.evL.euf;
                        eyVar2.a(i, pbData2, aQp, djVar7.aQE());
                    }
                }
                if (pbData.aOm() != null && pbData.aOm().size() >= 1 && pbData.aOm().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aOm().get(0).getId(), 0L);
                    djVar3 = this.evL.euf;
                    long c2 = com.baidu.adp.lib.h.b.c(djVar3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.ap bms = pbData.aOm().get(0).bms();
                        if (bms == null) {
                            bms = new com.baidu.tbadk.core.data.ap();
                        }
                        ArrayList<ap.a> qG = bms.qG();
                        if (qG == null) {
                            qG = new ArrayList<>();
                        }
                        qG.add(0, aVar);
                        bms.bR(abVar.sendCount + bms.qF());
                        bms.h(qG);
                        pbData.aOm().get(0).a(bms);
                        eyVar = this.evL.euP;
                        eyVar.aRW().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
