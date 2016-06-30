package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj extends CustomMessageListener {
    final /* synthetic */ dg dRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(dg dgVar, int i) {
        super(i);
        this.dRE = dgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.dRE.getPbData() != null && this.dRE.getPbData().aDN() != null && this.dRE.getPbData().aDN().getSignData() != null && signData.forumId.equals(this.dRE.getPbData().getForumId())) {
                this.dRE.getPbData().aDN().getSignData().is_signed = signData.is_signed;
            }
        }
    }
}
