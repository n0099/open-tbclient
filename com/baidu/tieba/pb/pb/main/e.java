package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, int i) {
        super(i);
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        da daVar;
        cc ccVar4;
        da daVar2;
        cc ccVar5;
        cc ccVar6;
        cc ccVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.l)) {
            com.baidu.tbadk.core.data.l lVar = (com.baidu.tbadk.core.data.l) customResponsedMessage.getData();
            r.a aVar = new r.a();
            aVar.giftId = lVar.getId();
            aVar.VG = lVar.getName();
            aVar.thumbnailUrl = lVar.getThumbnailUrl();
            ccVar = this.cCm.cBG;
            com.baidu.tieba.pb.a.c pbData = ccVar.getPbData();
            if (pbData != null) {
                ccVar2 = this.cCm.cBG;
                if (ccVar2.akM() != null) {
                    ccVar4 = this.cCm.cBG;
                    if (ccVar4.akM().getUserIdLong() == lVar.getToUserId()) {
                        daVar2 = this.cCm.cBL;
                        int sendCount = lVar.getSendCount();
                        ccVar5 = this.cCm.cBG;
                        com.baidu.tieba.pb.a.c pbData2 = ccVar5.getPbData();
                        ccVar6 = this.cCm.cBG;
                        boolean akF = ccVar6.akF();
                        ccVar7 = this.cCm.cBG;
                        daVar2.a(sendCount, pbData2, akF, ccVar7.getRequestType());
                    }
                }
                if (pbData.ajA() != null && pbData.ajA().size() >= 1 && pbData.ajA().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.ajA().get(0).getId(), 0L);
                    ccVar3 = this.cCm.cBG;
                    long c2 = com.baidu.adp.lib.h.b.c(ccVar3.getThreadID(), 0L);
                    if (c == lVar.getPostId() && c2 == lVar.getThreadId()) {
                        com.baidu.tbadk.core.data.r aDm = pbData.ajA().get(0).aDm();
                        if (aDm == null) {
                            aDm = new com.baidu.tbadk.core.data.r();
                        }
                        ArrayList<r.a> si = aDm.si();
                        if (si == null) {
                            si = new ArrayList<>();
                        }
                        si.add(0, aVar);
                        aDm.bH(lVar.getSendCount() + aDm.sh());
                        aDm.i(si);
                        pbData.ajA().get(0).a(aDm);
                        daVar = this.cCm.cBL;
                        daVar.als().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
