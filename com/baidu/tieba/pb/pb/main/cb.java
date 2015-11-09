package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.ca;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb extends CustomMessageListener {
    final /* synthetic */ ca ckZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(ca caVar, int i) {
        super(i);
        this.ckZ = caVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        int i;
        ca.a aVar;
        this.ckZ.ckU = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ckZ.unique_id;
            if (tag == bdUniqueId) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                com.baidu.tieba.pb.a.c pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData != null) {
                    this.ckZ.g(pbData);
                    this.ckZ.c(pbData);
                    aVar = this.ckZ.ckP;
                    if (aVar != null && pbData != null) {
                        com.baidu.adp.lib.g.h.hh().post(new cc(this, pbPageReadLocalResponseMessage, pbData));
                    }
                }
                ca caVar = this.ckZ;
                i = this.ckZ.mRequestType;
                caVar.jf(i);
            }
        }
    }
}
