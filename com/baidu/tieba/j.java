package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
class j implements d {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void t(Object obj) {
        if (obj != null) {
            this.acU.dx(com.baidu.adp.lib.g.c.f(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.acU, NotLoginGuideActivityConfig.FROM_LOGO)));
        this.acU.finish();
    }
}
