package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ LoginActivity cdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(LoginActivity loginActivity, int i) {
        super(i);
        this.cdc = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.u)) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) customResponsedMessage.getData();
            if (uVar.Vq == 0) {
                this.cdc.aea();
            } else {
                this.cdc.jw(uVar.errorMsg);
            }
        }
    }
}
