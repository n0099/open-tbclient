package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements FragmentTabHost.b {
    final /* synthetic */ aa fuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.fuh = aaVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
    public void f(int i, boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
    }
}
