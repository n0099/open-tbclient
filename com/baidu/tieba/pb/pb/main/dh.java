package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.dg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh extends CustomMessageListener {
    final /* synthetic */ dg dRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh(dg dgVar, int i) {
        super(i);
        this.dRE = dgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.h pbData;
        dg.a aVar;
        this.dRE.dRr = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dRE.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.dRE.i(pbData);
            this.dRE.d(pbData);
            if (pbData.aDO() != null) {
                pbData.aDO().bH(0);
            }
            aVar = this.dRE.dRi;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.dM().post(new di(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
