package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ae;
import java.util.ArrayList;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PbActivity pbActivity, int i) {
        super(i);
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        el elVar;
        cw cwVar4;
        el elVar2;
        cw cwVar5;
        cw cwVar6;
        cw cwVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.s)) {
            com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) customResponsedMessage.getData();
            ae.a aVar = new ae.a();
            aVar.giftId = sVar.getId();
            aVar.EV = sVar.getName();
            aVar.thumbnailUrl = sVar.getThumbnailUrl();
            cwVar = this.djE.dih;
            com.baidu.tieba.pb.data.e pbData = cwVar.getPbData();
            if (pbData != null) {
                cwVar2 = this.djE.dih;
                if (cwVar2.axI() != null) {
                    cwVar4 = this.djE.dih;
                    if (cwVar4.axI().getUserIdLong() == sVar.getToUserId()) {
                        elVar2 = this.djE.diR;
                        int sendCount = sVar.getSendCount();
                        cwVar5 = this.djE.dih;
                        com.baidu.tieba.pb.data.e pbData2 = cwVar5.getPbData();
                        cwVar6 = this.djE.dih;
                        boolean axB = cwVar6.axB();
                        cwVar7 = this.djE.dih;
                        elVar2.a(sendCount, pbData2, axB, cwVar7.getRequestType());
                    }
                }
                if (pbData.avC() != null && pbData.avC().size() >= 1 && pbData.avC().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.avC().get(0).getId(), 0L);
                    cwVar3 = this.djE.dih;
                    long c2 = com.baidu.adp.lib.h.b.c(cwVar3.getThreadID(), 0L);
                    if (c == sVar.getPostId() && c2 == sVar.getThreadId()) {
                        com.baidu.tbadk.core.data.ae aUb = pbData.avC().get(0).aUb();
                        if (aUb == null) {
                            aUb = new com.baidu.tbadk.core.data.ae();
                        }
                        ArrayList<ae.a> pN = aUb.pN();
                        if (pN == null) {
                            pN = new ArrayList<>();
                        }
                        pN.add(0, aVar);
                        aUb.bF(sVar.getSendCount() + aUb.pM());
                        aUb.g(pN);
                        pbData.avC().get(0).a(aUb);
                        elVar = this.djE.diR;
                        elVar.ayU().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
