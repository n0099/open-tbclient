package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends CustomMessageListener {
    final /* synthetic */ dh epX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(dh dhVar, int i) {
        super(i);
        this.epX = dhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.epX.getPbData() != null && this.epX.getPbData().aLP() != null && this.epX.getPbData().aLP().getSignData() != null && signData.forumId.equals(this.epX.getPbData().getForumId())) {
                this.epX.getPbData().aLP().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
