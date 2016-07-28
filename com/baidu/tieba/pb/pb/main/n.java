package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ak;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        ew ewVar;
        dh dhVar4;
        ew ewVar2;
        dh dhVar5;
        dh dhVar6;
        dh dhVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.w)) {
            com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) customResponsedMessage.getData();
            ak.a aVar = new ak.a();
            aVar.giftId = wVar.id;
            aVar.FC = wVar.name;
            aVar.thumbnailUrl = wVar.thumbnailUrl;
            dhVar = this.ebT.eas;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData != null) {
                dhVar2 = this.ebT.eas;
                if (dhVar2.aJd() != null) {
                    dhVar4 = this.ebT.eas;
                    if (dhVar4.aJd().getUserIdLong() == wVar.toUserId) {
                        ewVar2 = this.ebT.ebb;
                        int i = wVar.sendCount;
                        dhVar5 = this.ebT.eas;
                        com.baidu.tieba.pb.data.h pbData2 = dhVar5.getPbData();
                        dhVar6 = this.ebT.eas;
                        boolean aIX = dhVar6.aIX();
                        dhVar7 = this.ebT.eas;
                        ewVar2.a(i, pbData2, aIX, dhVar7.aJm());
                    }
                }
                if (pbData.aGZ() != null && pbData.aGZ().size() >= 1 && pbData.aGZ().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aGZ().get(0).getId(), 0L);
                    dhVar3 = this.ebT.eas;
                    long c2 = com.baidu.adp.lib.h.b.c(dhVar3.getThreadID(), 0L);
                    if (c == wVar.postId && c2 == wVar.threadId) {
                        com.baidu.tbadk.core.data.ak bfK = pbData.aGZ().get(0).bfK();
                        if (bfK == null) {
                            bfK = new com.baidu.tbadk.core.data.ak();
                        }
                        ArrayList<ak.a> pq = bfK.pq();
                        if (pq == null) {
                            pq = new ArrayList<>();
                        }
                        pq.add(0, aVar);
                        bfK.bE(wVar.sendCount + bfK.pp());
                        bfK.h(pq);
                        pbData.aGZ().get(0).a(bfK);
                        ewVar = this.ebT.ebb;
                        ewVar.aKs().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
