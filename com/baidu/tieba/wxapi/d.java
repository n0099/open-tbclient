package com.baidu.tieba.wxapi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d extends AuthorizationListener {
    final /* synthetic */ WXEntryActivity eud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.eud = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        ag agVar = new ag();
        agVar.WE = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, agVar));
        this.eud.closeActivity();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        ag agVar = new ag();
        agVar.WE = 2;
        agVar.errorCode = i;
        agVar.errorMsg = str;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, agVar));
        this.eud.closeActivity();
    }
}
