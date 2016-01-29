package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ag;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ LoginActivity cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(LoginActivity loginActivity, int i) {
        super(i);
        this.cGw = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
            ag agVar = (ag) customResponsedMessage.getData();
            if (agVar.WE == 0) {
                this.cGw.anN();
            } else {
                this.cGw.ko(agVar.errorMsg);
            }
        }
    }
}
