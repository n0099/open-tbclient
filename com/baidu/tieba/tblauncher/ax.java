package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", false);
    }
}
