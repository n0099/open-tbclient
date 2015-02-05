package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
class j implements d {
    final /* synthetic */ LogoActivity alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.alh = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void A(Object obj) {
        if (obj != null) {
            this.alh.eg(com.baidu.adp.lib.g.c.toInt(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.alh.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
        this.alh.finish();
    }
}
