package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh extends CustomMessageListener {
    final /* synthetic */ PbModel eqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh(PbModel pbModel, int i) {
        super(i);
        this.eqh = pbModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.eqh.getPbData() != null && this.eqh.getPbData().aIz() != null && this.eqh.getPbData().aIz().getSignData() != null && signData.forumId.equals(this.eqh.getPbData().getForumId())) {
                this.eqh.getPbData().aIz().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
