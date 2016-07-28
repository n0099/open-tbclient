package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.dh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di extends CustomMessageListener {
    final /* synthetic */ dh edS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(dh dhVar, int i) {
        super(i);
        this.edS = dhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.h pbData;
        dh.a aVar;
        this.edS.edF = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.edS.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.edS.i(pbData);
            this.edS.d(pbData);
            if (pbData.aGY() != null) {
                pbData.aGY().bG(0);
            }
            aVar = this.edS.edw;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.dL().post(new dj(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
