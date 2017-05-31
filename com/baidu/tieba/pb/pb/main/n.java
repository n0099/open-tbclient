package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fx fxVar;
        PbModel pbModel4;
        fx fxVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
            com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
            as.a aVar = new as.a();
            aVar.giftId = abVar.id;
            aVar.giftName = abVar.name;
            aVar.Vm = abVar.Vm;
            pbModel = this.enc.ele;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.enc.ele;
                if (pbModel2.aKU() != null) {
                    pbModel4 = this.enc.ele;
                    if (pbModel4.aKU().getUserIdLong() == abVar.toUserId) {
                        fxVar2 = this.enc.elU;
                        int i = abVar.sendCount;
                        pbModel5 = this.enc.ele;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.enc.ele;
                        boolean aKN = pbModel6.aKN();
                        pbModel7 = this.enc.ele;
                        fxVar2.a(i, pbData2, aKN, pbModel7.aLd());
                    }
                }
                if (pbData.aID() != null && pbData.aID().size() >= 1 && pbData.aID().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aID().get(0).getId(), 0L);
                    pbModel3 = this.enc.ele;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.as bin = pbData.aID().get(0).bin();
                        if (bin == null) {
                            bin = new com.baidu.tbadk.core.data.as();
                        }
                        ArrayList<as.a> qw = bin.qw();
                        if (qw == null) {
                            qw = new ArrayList<>();
                        }
                        qw.add(0, aVar);
                        bin.bM(abVar.sendCount + bin.qv());
                        bin.g(qw);
                        pbData.aID().get(0).a(bin);
                        fxVar = this.enc.elU;
                        fxVar.aMu().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
