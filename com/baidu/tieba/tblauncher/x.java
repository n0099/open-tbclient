package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements FragmentTabHost.b {
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dKW = wVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
    public void c(int i, boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
    }
}
