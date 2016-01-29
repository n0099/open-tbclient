package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbActivity pbActivity, int i) {
        super(i);
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        dz dzVar;
        cm cmVar4;
        dz dzVar2;
        cm cmVar5;
        cm cmVar6;
        cm cmVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.o)) {
            com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) customResponsedMessage.getData();
            v.a aVar = new v.a();
            aVar.giftId = oVar.getId();
            aVar.Oy = oVar.getName();
            aVar.thumbnailUrl = oVar.getThumbnailUrl();
            cmVar = this.cNq.cMF;
            com.baidu.tieba.pb.a.c pbData = cmVar.getPbData();
            if (pbData != null) {
                cmVar2 = this.cNq.cMF;
                if (cmVar2.apW() != null) {
                    cmVar4 = this.cNq.cMF;
                    if (cmVar4.apW().getUserIdLong() == oVar.getToUserId()) {
                        dzVar2 = this.cNq.cMK;
                        int sendCount = oVar.getSendCount();
                        cmVar5 = this.cNq.cMF;
                        com.baidu.tieba.pb.a.c pbData2 = cmVar5.getPbData();
                        cmVar6 = this.cNq.cMF;
                        boolean apP = cmVar6.apP();
                        cmVar7 = this.cNq.cMF;
                        dzVar2.a(sendCount, pbData2, apP, cmVar7.aqe());
                    }
                }
                if (pbData.aoG() != null && pbData.aoG().size() >= 1 && pbData.aoG().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aoG().get(0).getId(), 0L);
                    cmVar3 = this.cNq.cMF;
                    long c2 = com.baidu.adp.lib.h.b.c(cmVar3.getThreadID(), 0L);
                    if (c == oVar.getPostId() && c2 == oVar.getThreadId()) {
                        com.baidu.tbadk.core.data.v aME = pbData.aoG().get(0).aME();
                        if (aME == null) {
                            aME = new com.baidu.tbadk.core.data.v();
                        }
                        ArrayList<v.a> sy = aME.sy();
                        if (sy == null) {
                            sy = new ArrayList<>();
                        }
                        sy.add(0, aVar);
                        aME.bR(oVar.getSendCount() + aME.sx());
                        aME.j(sy);
                        pbData.aoG().get(0).a(aME);
                        dzVar = this.cNq.cMK;
                        dzVar.arb().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
