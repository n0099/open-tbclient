package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ LoginActivity eoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(LoginActivity loginActivity, int i) {
        super(i);
        this.eoh = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
            bl blVar = (bl) customResponsedMessage.getData();
            if (blVar.Xm == 0) {
                this.eoh.aLu();
            } else {
                this.eoh.ot(blVar.errorMsg);
            }
        }
    }
}
