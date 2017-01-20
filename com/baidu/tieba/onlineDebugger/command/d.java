package com.baidu.tieba.onlineDebugger.command;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b ebH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ebH = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(BdBaseApplication.getInst().getApp()).createRefreshCfg(2, false)));
    }
}
