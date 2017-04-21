package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ GuideActivity dsR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GuideActivity guideActivity, int i) {
        super(i);
        this.dsR = guideActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
            this.dsR.dsI = false;
        } else if (httpResponsedMessage.getError() == 0) {
            if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                this.dsR.dsI = true;
                return;
            }
            this.dsR.dsI = false;
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("jump_to_new_user_guide", false);
        } else {
            this.dsR.dsI = false;
        }
    }
}
