package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends CustomMessageListener {
    final /* synthetic */ bl cjM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bl blVar, int i) {
        super(i);
        this.cjM = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        int i;
        bl.a aVar;
        this.cjM.cjH = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.cjM.unique_id;
            if (tag == bdUniqueId) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                com.baidu.tieba.pb.a.b pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData != null) {
                    this.cjM.g(pbData);
                    this.cjM.c(pbData);
                    aVar = this.cjM.cjC;
                    if (aVar != null && pbData != null) {
                        com.baidu.adp.lib.g.h.hg().post(new bn(this, pbPageReadLocalResponseMessage, pbData));
                    }
                }
                bl blVar = this.cjM;
                i = this.cjM.mRequestType;
                blVar.iQ(i);
            }
        }
    }
}
