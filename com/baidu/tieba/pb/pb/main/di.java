package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.dh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di extends CustomMessageListener {
    final /* synthetic */ dh epX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(dh dhVar, int i) {
        super(i);
        this.epX = dhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.h pbData;
        dh.a aVar;
        this.epX.epK = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.epX.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.epX.i(pbData);
            this.epX.d(pbData);
            if (pbData.aLQ() != null) {
                pbData.aLQ().bT(0);
            }
            aVar = this.epX.epB;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.eG().post(new dj(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
