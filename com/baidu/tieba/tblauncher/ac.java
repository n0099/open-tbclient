package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ac implements FragmentTabHost.b {
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.exg = abVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
    public void e(int i, boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
    }
}
