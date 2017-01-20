package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ez ezVar;
        PbModel pbModel4;
        ez ezVar2;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
            com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
            ap.a aVar = new ap.a();
            aVar.giftId = abVar.id;
            aVar.giftName = abVar.name;
            aVar.QC = abVar.QC;
            pbModel = this.eiV.ehh;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData != null) {
                pbModel2 = this.eiV.ehh;
                if (pbModel2.aMf() != null) {
                    pbModel4 = this.eiV.ehh;
                    if (pbModel4.aMf().getUserIdLong() == abVar.toUserId) {
                        ezVar2 = this.eiV.ehV;
                        int i = abVar.sendCount;
                        pbModel5 = this.eiV.ehh;
                        com.baidu.tieba.pb.data.f pbData2 = pbModel5.getPbData();
                        pbModel6 = this.eiV.ehh;
                        boolean aLY = pbModel6.aLY();
                        pbModel7 = this.eiV.ehh;
                        ezVar2.a(i, pbData2, aLY, pbModel7.aMo());
                    }
                }
                if (pbData.aKb() != null && pbData.aKb().size() >= 1 && pbData.aKb().get(0) != null) {
                    long c = com.baidu.adp.lib.g.b.c(pbData.aKb().get(0).getId(), 0L);
                    pbModel3 = this.eiV.ehh;
                    long c2 = com.baidu.adp.lib.g.b.c(pbModel3.getThreadID(), 0L);
                    if (c == abVar.postId && c2 == abVar.threadId) {
                        com.baidu.tbadk.core.data.ap bhX = pbData.aKb().get(0).bhX();
                        if (bhX == null) {
                            bhX = new com.baidu.tbadk.core.data.ap();
                        }
                        ArrayList<ap.a> qA = bhX.qA();
                        if (qA == null) {
                            qA = new ArrayList<>();
                        }
                        qA.add(0, aVar);
                        bhX.bQ(abVar.sendCount + bhX.qz());
                        bhX.h(qA);
                        pbData.aKb().get(0).a(bhX);
                        ezVar = this.eiV.ehV;
                        ezVar.aNE().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
