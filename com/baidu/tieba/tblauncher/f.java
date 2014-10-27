package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class f extends HttpMessageListener {
    final /* synthetic */ GuideActivity bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GuideActivity guideActivity, int i) {
        super(i);
        this.bOn = guideActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
            this.bOn.bOh = false;
        } else if (httpResponsedMessage.getError() == 0) {
            if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                this.bOn.bOh = true;
                return;
            }
            this.bOn.bOh = false;
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("jump_to_new_user_guide", false);
        } else {
            this.bOn.bOh = false;
        }
    }
}
