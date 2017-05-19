package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ ah fzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ah ahVar) {
        this.fzg = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        int i = 3;
        mainTabActivity = this.fzg.fyW;
        mainTabActivity2 = this.fzg.fyW;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(mainTabActivity2.getPageContext().getPageActivity())));
        fragmentTabHost = this.fzg.bCH;
        if (fragmentTabHost.getCurrentTabType() != 3) {
            fragmentTabHost2 = this.fzg.bCH;
            if (fragmentTabHost2.getCurrentTabType() != 2) {
                i = 0;
            } else {
                i = 1;
            }
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10378").s("obj_type", i));
    }
}
