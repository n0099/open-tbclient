package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx extends CustomMessageListener {
    final /* synthetic */ cw dlN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(cw cwVar, int i) {
        super(i);
        this.dlN = cwVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.e pbData;
        cw.a aVar;
        this.dlN.dlA = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dlN.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.dlN.i(pbData);
            this.dlN.d(pbData);
            if (pbData.avB() != null) {
                pbData.avB().bH(0);
            }
            aVar = this.dlN.dlr;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.dL().post(new cy(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
