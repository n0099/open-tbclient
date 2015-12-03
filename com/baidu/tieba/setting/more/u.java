package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t dnq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.dnq = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MoreActivity moreActivity;
        MoreActivity moreActivity2;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        TbadkCoreApplication.m411getInst().deleteAccountAllInfo(currentAccount);
        moreActivity = this.dnq.this$0;
        TbadkCoreApplication.setCurrentAccount(null, moreActivity.getPageContext().getPageActivity());
        com.baidu.tbadk.coreExtra.a.a.wP().wR();
        TbadkCoreApplication.m411getInst().onUserChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_MATINTAB, null));
        moreActivity2 = this.dnq.this$0;
        moreActivity2.finish();
    }
}
