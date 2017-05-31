package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef extends CustomMessageListener {
    final /* synthetic */ PbModel eqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef(PbModel pbModel, int i) {
        super(i);
        this.eqh = pbModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.f pbData;
        PbModel.a aVar;
        this.eqh.epM = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eqh.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.eqh.j(pbData);
            this.eqh.e(pbData);
            if (pbData.aIB() != null) {
                pbData.aIB().bP(0);
            }
            aVar = this.eqh.epD;
            if (aVar != null && pbData != null) {
                com.baidu.adp.lib.g.h.fS().post(new eg(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
