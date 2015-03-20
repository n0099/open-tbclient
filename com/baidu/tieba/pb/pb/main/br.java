package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ bq bJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bq bqVar, int i) {
        super(i);
        this.bJu = bqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.a.b pbData;
        bu buVar;
        bdUniqueId = this.bJu.unique_id;
        if (bdUniqueId == customResponsedMessage.getOrginalMessage().getTag() && customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId2 = this.bJu.unique_id;
            if (tag != bdUniqueId2 || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.bJu.c(pbData);
            buVar = this.bJu.bJn;
            if (buVar != null && pbData != null) {
                com.baidu.adp.lib.g.i.hI().post(new bs(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
