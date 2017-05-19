package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy extends CustomMessageListener {
    final /* synthetic */ PbModel eku;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy(PbModel pbModel, int i) {
        super(i);
        this.eku = pbModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.eku.getPbData() != null && this.eku.getPbData().aHE() != null && this.eku.getPbData().aHE().getSignData() != null && signData.forumId.equals(this.eku.getPbData().getForumId())) {
                this.eku.getPbData().aHE().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
