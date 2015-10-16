package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ LoginActivity cdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(LoginActivity loginActivity, int i) {
        super(i);
        this.cdn = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.v)) {
            com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) customResponsedMessage.getData();
            if (vVar.Vs == 0) {
                this.cdn.aea();
            } else {
                this.cdn.jw(vVar.errorMsg);
            }
        }
    }
}
