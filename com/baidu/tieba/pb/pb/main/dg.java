package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends CustomMessageListener {
    final /* synthetic */ df dju;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(df dfVar, int i) {
        super(i);
        this.dju = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
        com.baidu.tieba.pb.data.e pbData;
        df.c cVar;
        this.dju.djh = true;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dju.unique_id;
            if (tag != bdUniqueId || (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) == null) {
                return;
            }
            this.dju.i(pbData);
            this.dju.d(pbData);
            if (pbData.avv() != null) {
                pbData.avv().bV(0);
            }
            cVar = this.dju.diX;
            if (cVar != null && pbData != null) {
                com.baidu.adp.lib.h.h.hx().post(new dh(this, pbPageReadLocalResponseMessage, pbData));
            }
        }
    }
}
