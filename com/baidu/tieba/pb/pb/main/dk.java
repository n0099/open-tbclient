package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends CustomMessageListener {
    final /* synthetic */ dh erV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(dh dhVar, int i) {
        super(i);
        this.erV = dhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.erV.getPbData() != null && this.erV.getPbData().aMr() != null && this.erV.getPbData().aMr().getSignData() != null && signData.forumId.equals(this.erV.getPbData().getForumId())) {
                this.erV.getPbData().aMr().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
