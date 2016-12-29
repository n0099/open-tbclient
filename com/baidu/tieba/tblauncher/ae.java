package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* loaded from: classes.dex */
class ae implements FragmentTabHost.b {
    final /* synthetic */ ad flb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.flb = adVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
    public void f(int i, boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
    }
}
