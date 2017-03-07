package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ z fyG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(z zVar) {
        this.fyG = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        int i = 3;
        mainTabActivity = this.fyG.fyz;
        mainTabActivity2 = this.fyG.fyz;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(mainTabActivity2.getPageContext().getPageActivity())));
        fragmentTabHost = this.fyG.bAw;
        if (fragmentTabHost.getCurrentTabType() != 3) {
            fragmentTabHost2 = this.fyG.bAw;
            if (fragmentTabHost2.getCurrentTabType() != 2) {
                i = 0;
            } else {
                i = 1;
            }
        }
        TiebaStatic.log(new as("c10378").s("obj_type", i));
    }
}
