package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm extends CustomMessageListener {
    final /* synthetic */ dj exP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm(dj djVar, int i) {
        super(i);
        this.exP = djVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.exP.getPbData() != null && this.exP.getPbData().aOk() != null && this.exP.getPbData().aOk().getSignData() != null && signData.forumId.equals(this.exP.getPbData().getForumId())) {
                this.exP.getPbData().aOk().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
