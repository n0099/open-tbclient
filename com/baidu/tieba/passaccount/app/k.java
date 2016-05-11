package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.aw;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ LoginActivity dbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(LoginActivity loginActivity, int i) {
        super(i);
        this.dbZ = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aw)) {
            aw awVar = (aw) customResponsedMessage.getData();
            if (awVar.PS == 0) {
                this.dbZ.auH();
            } else {
                this.dbZ.lF(awVar.errorMsg);
            }
        }
    }
}
