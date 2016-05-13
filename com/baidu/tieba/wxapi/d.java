package com.baidu.tieba.wxapi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d extends AuthorizationListener {
    final /* synthetic */ WXEntryActivity feR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.feR = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        aw awVar = new aw();
        awVar.PS = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, awVar));
        this.feR.closeActivity();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        aw awVar = new aw();
        awVar.PS = 2;
        awVar.errorCode = i;
        awVar.errorMsg = str;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, awVar));
        this.feR.closeActivity();
    }
}
