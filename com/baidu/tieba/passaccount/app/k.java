package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ay;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ LoginActivity dIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(LoginActivity loginActivity, int i) {
        super(i);
        this.dIF = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ay)) {
            ay ayVar = (ay) customResponsedMessage.getData();
            if (ayVar.Qe == 0) {
                this.dIF.aCP();
            } else {
                this.dIF.ng(ayVar.errorMsg);
            }
        }
    }
}
