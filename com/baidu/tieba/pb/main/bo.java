package com.baidu.tieba.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends CustomMessageListener {
    final /* synthetic */ bn bxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bn bnVar, int i) {
        super(i);
        this.bxi = bnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.data.ah pbData;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bdUniqueId = this.bxi.unique_id;
        if (bdUniqueId == customResponsedMessage.getOrginalMessage().getTag() && customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId2 = this.bxi.unique_id;
            if (tag != bdUniqueId2 || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.bxi.c(pbData);
            bqVar = this.bxi.bxa;
            if (bqVar != null && pbData != null) {
                bqVar2 = this.bxi.bxa;
                bqVar2.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                bqVar3 = this.bxi.bxa;
                bqVar3.dV(false);
            }
        }
    }
}
