package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di extends CustomMessageListener {
    final /* synthetic */ df dju;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(df dfVar, int i) {
        super(i);
        this.dju = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.dju.getPbData() != null && this.dju.getPbData().avu() != null && this.dju.getPbData().avu().getSignData() != null && signData.getForumId().equals(this.dju.getPbData().getForumId())) {
                this.dju.getPbData().avu().getSignData().setIsSigned(signData.getSigned());
            }
        }
    }
}
