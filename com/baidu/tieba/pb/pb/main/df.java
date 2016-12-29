package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df extends CustomMessageListener {
    final /* synthetic */ dc ech;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df(dc dcVar, int i) {
        super(i);
        this.ech = dcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.ech.getPbData() != null && this.ech.getPbData().aIk() != null && this.ech.getPbData().aIk().getSignData() != null && signData.forumId.equals(this.ech.getPbData().getForumId())) {
                this.ech.getPbData().aIk().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
