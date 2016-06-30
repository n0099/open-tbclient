package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ag;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        es esVar;
        dg dgVar4;
        es esVar2;
        dg dgVar5;
        dg dgVar6;
        dg dgVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.u)) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) customResponsedMessage.getData();
            ag.a aVar = new ag.a();
            aVar.giftId = uVar.getId();
            aVar.Fc = uVar.getName();
            aVar.thumbnailUrl = uVar.getThumbnailUrl();
            dgVar = this.dPF.dOf;
            com.baidu.tieba.pb.data.h pbData = dgVar.getPbData();
            if (pbData != null) {
                dgVar2 = this.dPF.dOf;
                if (dgVar2.aFS() != null) {
                    dgVar4 = this.dPF.dOf;
                    if (dgVar4.aFS().getUserIdLong() == uVar.getToUserId()) {
                        esVar2 = this.dPF.dOO;
                        int sendCount = uVar.getSendCount();
                        dgVar5 = this.dPF.dOf;
                        com.baidu.tieba.pb.data.h pbData2 = dgVar5.getPbData();
                        dgVar6 = this.dPF.dOf;
                        boolean aFM = dgVar6.aFM();
                        dgVar7 = this.dPF.dOf;
                        esVar2.a(sendCount, pbData2, aFM, dgVar7.aGb());
                    }
                }
                if (pbData.aDP() != null && pbData.aDP().size() >= 1 && pbData.aDP().get(0) != null) {
                    long c = com.baidu.adp.lib.h.b.c(pbData.aDP().get(0).getId(), 0L);
                    dgVar3 = this.dPF.dOf;
                    long c2 = com.baidu.adp.lib.h.b.c(dgVar3.getThreadID(), 0L);
                    if (c == uVar.getPostId() && c2 == uVar.getThreadId()) {
                        com.baidu.tbadk.core.data.ag bcv = pbData.aDP().get(0).bcv();
                        if (bcv == null) {
                            bcv = new com.baidu.tbadk.core.data.ag();
                        }
                        ArrayList<ag.a> pH = bcv.pH();
                        if (pH == null) {
                            pH = new ArrayList<>();
                        }
                        pH.add(0, aVar);
                        bcv.bF(uVar.getSendCount() + bcv.pG());
                        bcv.g(pH);
                        pbData.aDP().get(0).a(bcv);
                        esVar = this.dPF.dOO;
                        esVar.aHh().notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
