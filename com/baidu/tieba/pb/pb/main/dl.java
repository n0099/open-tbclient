package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl extends CustomMessageListener {
    final /* synthetic */ PbModel eox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl(PbModel pbModel, int i) {
        super(i);
        this.eox = pbModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.eox.getPbData() != null && this.eox.getPbData().aKx() != null && this.eox.getPbData().aKx().getSignData() != null && signData.forumId.equals(this.eox.getPbData().getForumId())) {
                this.eox.getPbData().aKx().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
