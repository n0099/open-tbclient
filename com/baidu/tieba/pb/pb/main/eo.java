package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo extends CustomMessageListener {
    final /* synthetic */ PbModel ezs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(PbModel pbModel, int i) {
        super(i);
        this.ezs = pbModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.f pbData;
        PbModel.a aVar;
        this.ezs.eyW = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ezs.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.ezs.j(pbData);
            this.ezs.e(pbData);
            if (pbData.aMv() != null) {
                pbData.aMv().bP(0);
            }
            aVar = this.ezs.eyN;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.g.h.fR().post(new ep(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
