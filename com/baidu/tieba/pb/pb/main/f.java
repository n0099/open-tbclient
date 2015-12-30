package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbActivity pbActivity, int i) {
        super(i);
        this.cFS = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        dk dkVar;
        cf cfVar4;
        dk dkVar2;
        cf cfVar5;
        cf cfVar6;
        cf cfVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.l)) {
            com.baidu.tbadk.core.data.l lVar = (com.baidu.tbadk.core.data.l) customResponsedMessage.getData();
            r.a aVar = new r.a();
            aVar.giftId = lVar.getId();
            aVar.Wg = lVar.getName();
            aVar.thumbnailUrl = lVar.getThumbnailUrl();
            cfVar = this.cFS.cFl;
            com.baidu.tieba.pb.a.c pbData = cfVar.getPbData();
            if (pbData != null) {
                cfVar2 = this.cFS.cFl;
                if (cfVar2.alT() != null) {
                    cfVar4 = this.cFS.cFl;
                    if (cfVar4.alT().getUserIdLong() == lVar.getToUserId()) {
                        dkVar2 = this.cFS.cFq;
                        int sendCount = lVar.getSendCount();
                        cfVar5 = this.cFS.cFl;
                        com.baidu.tieba.pb.a.c pbData2 = cfVar5.getPbData();
                        cfVar6 = this.cFS.cFl;
                        boolean alM = cfVar6.alM();
                        cfVar7 = this.cFS.cFl;
                        dkVar2.a(sendCount, pbData2, alM, cfVar7.getRequestType());
                    }
                }
                if (pbData.akI() != null && pbData.akI().size() >= 1 && pbData.akI().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.akI().get(0).getId(), 0L);
                    cfVar3 = this.cFS.cFl;
                    long c2 = com.baidu.adp.lib.h.b.c(cfVar3.getThreadID(), 0L);
                    if (c == lVar.getPostId() && c2 == lVar.getThreadId()) {
                        com.baidu.tbadk.core.data.r aFz = pbData.akI().get(0).aFz();
                        if (aFz == null) {
                            aFz = new com.baidu.tbadk.core.data.r();
                        }
                        ArrayList<r.a> rR = aFz.rR();
                        if (rR == null) {
                            rR = new ArrayList<>();
                        }
                        rR.add(0, aVar);
                        aFz.bA(lVar.getSendCount() + aFz.rQ());
                        aFz.i(rR);
                        pbData.akI().get(0).a(aFz);
                        dkVar = this.cFS.cFq;
                        dkVar.amE().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
