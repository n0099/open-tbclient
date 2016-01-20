package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ LoginActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(LoginActivity loginActivity, int i) {
        super(i);
        this.czQ = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
            com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
            if (yVar.WA == 0) {
                this.czQ.ajQ();
            } else {
                this.czQ.kk(yVar.errorMsg);
            }
        }
    }
}
