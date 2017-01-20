package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ LoginActivity ecm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(LoginActivity loginActivity, int i) {
        super(i);
        this.ecm = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
            bg bgVar = (bg) customResponsedMessage.getData();
            if (bgVar.Sv == 0) {
                this.ecm.aJa();
            } else {
                this.ecm.nU(bgVar.errorMsg);
            }
        }
    }
}
