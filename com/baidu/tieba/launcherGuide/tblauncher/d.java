package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ GuideActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GuideActivity guideActivity, int i) {
        super(i);
        this.cjt = guideActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
            this.cjt.cjn = false;
        } else if (httpResponsedMessage.getError() == 0) {
            if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                this.cjt.cjn = true;
                return;
            }
            this.cjt.cjn = false;
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("jump_to_new_user_guide", false);
        } else {
            this.cjt.cjn = false;
        }
    }
}
