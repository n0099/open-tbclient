package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.an;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        ex exVar;
        dh dhVar4;
        ex exVar2;
        dh dhVar5;
        dh dhVar6;
        dh dhVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
            com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
            an.a aVar = new an.a();
            aVar.giftId = zVar.id;
            aVar.HP = zVar.name;
            aVar.Rb = zVar.Rb;
            dhVar = this.eqa.eov;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData != null) {
                dhVar2 = this.eqa.eov;
                if (dhVar2.aOC() != null) {
                    dhVar4 = this.eqa.eov;
                    if (dhVar4.aOC().getUserIdLong() == zVar.toUserId) {
                        exVar2 = this.eqa.epe;
                        int i = zVar.sendCount;
                        dhVar5 = this.eqa.eov;
                        com.baidu.tieba.pb.data.h pbData2 = dhVar5.getPbData();
                        dhVar6 = this.eqa.eov;
                        boolean aOw = dhVar6.aOw();
                        dhVar7 = this.eqa.eov;
                        exVar2.a(i, pbData2, aOw, dhVar7.aOL());
                    }
                }
                if (pbData.aMt() != null && pbData.aMt().size() >= 1 && pbData.aMt().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aMt().get(0).getId(), 0L);
                    dhVar3 = this.eqa.eov;
                    long c2 = com.baidu.adp.lib.h.b.c(dhVar3.getThreadID(), 0L);
                    if (c == zVar.postId && c2 == zVar.threadId) {
                        com.baidu.tbadk.core.data.an bjX = pbData.aMt().get(0).bjX();
                        if (bjX == null) {
                            bjX = new com.baidu.tbadk.core.data.an();
                        }
                        ArrayList<an.a> qE = bjX.qE();
                        if (qE == null) {
                            qE = new ArrayList<>();
                        }
                        qE.add(0, aVar);
                        bjX.bR(zVar.sendCount + bjX.qD());
                        bjX.h(qE);
                        pbData.aMt().get(0).a(bjX);
                        exVar = this.eqa.epe;
                        exVar.aPS().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
