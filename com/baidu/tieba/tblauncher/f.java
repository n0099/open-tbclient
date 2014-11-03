package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class f extends HttpMessageListener {
    final /* synthetic */ GuideActivity bOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GuideActivity guideActivity, int i) {
        super(i);
        this.bOC = guideActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
            this.bOC.bOw = false;
        } else if (httpResponsedMessage.getError() == 0) {
            if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                this.bOC.bOw = true;
                return;
            }
            this.bOC.bOw = false;
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("jump_to_new_user_guide", false);
        } else {
            this.bOC.bOw = false;
        }
    }
}
