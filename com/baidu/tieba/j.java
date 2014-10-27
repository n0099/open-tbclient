package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
class j implements d {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void t(Object obj) {
        if (obj != null) {
            this.acP.dx(com.baidu.adp.lib.g.c.f(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.acP, NotLoginGuideActivityConfig.FROM_LOGO)));
        this.acP.finish();
    }
}
