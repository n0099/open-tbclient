package com.baidu.tieba.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ bq bBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bq bqVar, int i) {
        super(i);
        this.bBa = bqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.tbadkCore.b.i pbData;
        bt btVar;
        bt btVar2;
        bt btVar3;
        bdUniqueId = this.bBa.unique_id;
        if (bdUniqueId == customResponsedMessage.getOrginalMessage().getTag() && customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId2 = this.bBa.unique_id;
            if (tag != bdUniqueId2 || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.bBa.c(pbData);
            btVar = this.bBa.bAS;
            if (btVar != null && pbData != null) {
                btVar2 = this.bBa.bAS;
                btVar2.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                btVar3 = this.bBa.bAS;
                btVar3.dG(false);
            }
        }
    }
}
