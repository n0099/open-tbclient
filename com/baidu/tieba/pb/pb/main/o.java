package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.at;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        gg ggVar;
        PbModel pbModel4;
        gg ggVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ac)) {
            com.baidu.tbadk.core.data.ac acVar = (com.baidu.tbadk.core.data.ac) customResponsedMessage.getData();
            at.a aVar = new at.a();
            aVar.giftId = acVar.id;
            aVar.giftName = acVar.name;
            aVar.Vm = acVar.Vm;
            pbModel = this.ewh.eue;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.ewh.eue;
                if (pbModel2.aOR() != null) {
                    pbModel4 = this.ewh.eue;
                    if (pbModel4.aOR().getUserIdLong() == acVar.toUserId) {
                        ggVar2 = this.ewh.euU;
                        int i = acVar.sendCount;
                        pbModel5 = this.ewh.eue;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.ewh.eue;
                        boolean aOK = pbModel6.aOK();
                        pbModel7 = this.ewh.eue;
                        ggVar2.a(i, pbData2, aOK, pbModel7.aPa());
                    }
                }
                if (pbData.aMx() != null && pbData.aMx().size() >= 1 && pbData.aMx().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aMx().get(0).getId(), 0L);
                    pbModel3 = this.ewh.eue;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == acVar.postId && c2 == acVar.threadId) {
                        com.baidu.tbadk.core.data.at bmB = pbData.aMx().get(0).bmB();
                        if (bmB == null) {
                            bmB = new com.baidu.tbadk.core.data.at();
                        }
                        ArrayList<at.a> qt = bmB.qt();
                        if (qt == null) {
                            qt = new ArrayList<>();
                        }
                        qt.add(0, aVar);
                        bmB.bM(acVar.sendCount + bmB.qs());
                        bmB.g(qt);
                        pbData.aMx().get(0).a(bmB);
                        ggVar = this.ewh.euU;
                        ggVar.aQs().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
