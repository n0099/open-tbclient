package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ad;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(PbActivity pbActivity, int i) {
        super(i);
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        eu euVar;
        df dfVar4;
        eu euVar2;
        df dfVar5;
        df dfVar6;
        df dfVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.s)) {
            com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) customResponsedMessage.getData();
            ad.a aVar = new ad.a();
            aVar.giftId = sVar.getId();
            aVar.OF = sVar.getName();
            aVar.thumbnailUrl = sVar.getThumbnailUrl();
            dfVar = this.dht.dfV;
            com.baidu.tieba.pb.data.e pbData = dfVar.getPbData();
            if (pbData != null) {
                dfVar2 = this.dht.dfV;
                if (dfVar2.axl() != null) {
                    dfVar4 = this.dht.dfV;
                    if (dfVar4.axl().getUserIdLong() == sVar.getToUserId()) {
                        euVar2 = this.dht.dgF;
                        int sendCount = sVar.getSendCount();
                        dfVar5 = this.dht.dfV;
                        com.baidu.tieba.pb.data.e pbData2 = dfVar5.getPbData();
                        dfVar6 = this.dht.dfV;
                        boolean axe = dfVar6.axe();
                        dfVar7 = this.dht.dfV;
                        euVar2.a(sendCount, pbData2, axe, dfVar7.axt());
                    }
                }
                if (pbData.avw() != null && pbData.avw().size() >= 1 && pbData.avw().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.avw().get(0).getId(), 0L);
                    dfVar3 = this.dht.dfV;
                    long c2 = com.baidu.adp.lib.h.b.c(dfVar3.getThreadID(), 0L);
                    if (c == sVar.getPostId() && c2 == sVar.getThreadId()) {
                        com.baidu.tbadk.core.data.ad aTB = pbData.avw().get(0).aTB();
                        if (aTB == null) {
                            aTB = new com.baidu.tbadk.core.data.ad();
                        }
                        ArrayList<ad.a> st = aTB.st();
                        if (st == null) {
                            st = new ArrayList<>();
                        }
                        st.add(0, aVar);
                        aTB.bT(sVar.getSendCount() + aTB.ss());
                        aTB.g(st);
                        pbData.avw().get(0).a(aTB);
                        euVar = this.dht.dgF;
                        euVar.ayy().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
