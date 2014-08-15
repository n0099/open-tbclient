package com.baidu.tieba.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends CustomMessageListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bl blVar, int i) {
        super(i);
        this.a = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.data.aj pbData;
        bn bnVar;
        bn bnVar2;
        bdUniqueId = this.a.unique_id;
        if (bdUniqueId == customResponsedMessage.getOrginalMessage().getTag() && customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId2 = this.a.unique_id;
            if (tag != bdUniqueId2 || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.a.a(pbData);
            bnVar = this.a.y;
            if (bnVar != null && pbData != null) {
                bnVar2 = this.a.y;
                bnVar2.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
            }
        }
    }
}
