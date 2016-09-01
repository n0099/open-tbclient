package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.al;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x)) {
            com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
            al.a aVar = new al.a();
            aVar.giftId = xVar.id;
            aVar.HP = xVar.name;
            aVar.QV = xVar.QV;
            dhVar = this.eob.emx;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData != null) {
                dhVar2 = this.eob.emx;
                if (dhVar2.aNU() != null) {
                    dhVar4 = this.eob.emx;
                    if (dhVar4.aNU().getUserIdLong() == xVar.toUserId) {
                        exVar2 = this.eob.enh;
                        int i = xVar.sendCount;
                        dhVar5 = this.eob.emx;
                        com.baidu.tieba.pb.data.h pbData2 = dhVar5.getPbData();
                        dhVar6 = this.eob.emx;
                        boolean aNO = dhVar6.aNO();
                        dhVar7 = this.eob.emx;
                        exVar2.a(i, pbData2, aNO, dhVar7.aOd());
                    }
                }
                if (pbData.aLR() != null && pbData.aLR().size() >= 1 && pbData.aLR().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aLR().get(0).getId(), 0L);
                    dhVar3 = this.eob.emx;
                    long c2 = com.baidu.adp.lib.h.b.c(dhVar3.getThreadID(), 0L);
                    if (c == xVar.postId && c2 == xVar.threadId) {
                        com.baidu.tbadk.core.data.al bjl = pbData.aLR().get(0).bjl();
                        if (bjl == null) {
                            bjl = new com.baidu.tbadk.core.data.al();
                        }
                        ArrayList<al.a> qt = bjl.qt();
                        if (qt == null) {
                            qt = new ArrayList<>();
                        }
                        qt.add(0, aVar);
                        bjl.bR(xVar.sendCount + bjl.qs());
                        bjl.h(qt);
                        pbData.aLR().get(0).a(bjl);
                        exVar = this.eob.enh;
                        exVar.aPj().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
