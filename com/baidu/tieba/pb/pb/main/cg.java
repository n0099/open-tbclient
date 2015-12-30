package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg extends CustomMessageListener {
    final /* synthetic */ cf cHv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(cf cfVar, int i) {
        super(i);
        this.cHv = cfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.a.c pbData;
        cf.c cVar;
        this.cHv.cHl = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.cHv.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.cHv.h(pbData);
            this.cHv.c(pbData);
            if (pbData.akH() != null) {
                pbData.akH().bB(0);
            }
            cVar = this.cHv.cHf;
            if (cVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.hj().post(new ch(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
