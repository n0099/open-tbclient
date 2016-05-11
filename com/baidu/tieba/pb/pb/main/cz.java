package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz extends CustomMessageListener {
    final /* synthetic */ cw dlN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz(cw cwVar, int i) {
        super(i);
        this.dlN = cwVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.dlN.getPbData() != null && this.dlN.getPbData().avA() != null && this.dlN.getPbData().avA().getSignData() != null && signData.getForumId().equals(this.dlN.getPbData().getForumId())) {
                this.dlN.getPbData().avA().getSignData().setIsSigned(signData.getSigned());
            }
        }
    }
}
