package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ao;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        er erVar;
        dc dcVar4;
        er erVar2;
        dc dcVar5;
        dc dcVar6;
        dc dcVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
            com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
            ao.a aVar = new ao.a();
            aVar.giftId = aaVar.id;
            aVar.HQ = aaVar.name;
            aVar.Rt = aaVar.Rt;
            dcVar = this.eah.dYA;
            com.baidu.tieba.pb.data.f pbData = dcVar.getPbData();
            if (pbData != null) {
                dcVar2 = this.eah.dYA;
                if (dcVar2.aKs() != null) {
                    dcVar4 = this.eah.dYA;
                    if (dcVar4.aKs().getUserIdLong() == aaVar.toUserId) {
                        erVar2 = this.eah.dZk;
                        int i = aaVar.sendCount;
                        dcVar5 = this.eah.dYA;
                        com.baidu.tieba.pb.data.f pbData2 = dcVar5.getPbData();
                        dcVar6 = this.eah.dYA;
                        boolean aKl = dcVar6.aKl();
                        dcVar7 = this.eah.dYA;
                        erVar2.a(i, pbData2, aKl, dcVar7.aKB());
                    }
                }
                if (pbData.aIm() != null && pbData.aIm().size() >= 1 && pbData.aIm().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aIm().get(0).getId(), 0L);
                    dcVar3 = this.eah.dYA;
                    long c2 = com.baidu.adp.lib.h.b.c(dcVar3.getThreadID(), 0L);
                    if (c == aaVar.postId && c2 == aaVar.threadId) {
                        com.baidu.tbadk.core.data.ao bgh = pbData.aIm().get(0).bgh();
                        if (bgh == null) {
                            bgh = new com.baidu.tbadk.core.data.ao();
                        }
                        ArrayList<ao.a> qH = bgh.qH();
                        if (qH == null) {
                            qH = new ArrayList<>();
                        }
                        qH.add(0, aVar);
                        bgh.bR(aaVar.sendCount + bgh.qG());
                        bgh.h(qH);
                        pbData.aIm().get(0).a(bgh);
                        erVar = this.eah.dZk;
                        erVar.aLQ().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
