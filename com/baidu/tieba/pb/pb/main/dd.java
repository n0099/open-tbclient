package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.dc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd extends CustomMessageListener {
    final /* synthetic */ dc ech;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd(dc dcVar, int i) {
        super(i);
        this.ech = dcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.f pbData;
        dc.a aVar;
        this.ech.ebS = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ech.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.ech.i(pbData);
            this.ech.d(pbData);
            if (pbData.aIl() != null) {
                pbData.aIl().bU(0);
            }
            aVar = this.ech.ebJ;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.eG().post(new de(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
