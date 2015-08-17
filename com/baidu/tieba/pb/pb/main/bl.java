package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends CustomMessageListener {
    final /* synthetic */ bk ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bk bkVar, int i) {
        super(i);
        this.ccq = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        int i;
        bk.a aVar;
        this.ccq.ccn = true;
        bdUniqueId = this.ccq.unique_id;
        if (bdUniqueId == customResponsedMessage.getOrginalMessage().getTag() && customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId2 = this.ccq.unique_id;
            if (tag == bdUniqueId2) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                com.baidu.tieba.pb.a.b pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData != null) {
                    this.ccq.g(pbData);
                    this.ccq.c(pbData);
                    aVar = this.ccq.cci;
                    if (aVar != null && pbData != null) {
                        com.baidu.adp.lib.g.h.hi().post(new bm(this, pbPageReadLocalResponseMessage, pbData));
                    }
                }
                bk bkVar = this.ccq;
                i = this.ccq.mRequestType;
                bkVar.iu(i);
            }
        }
    }
}
