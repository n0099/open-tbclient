package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements SlidingMenu.OnClosedListener {
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ai aiVar) {
        this.cMQ = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        this.cMQ.y(1.0f);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }
}
