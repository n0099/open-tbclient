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
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        FragmentTabHost fragmentTabHost3;
        int i = 2;
        mainTabActivity = this.dfH.dfC;
        mainTabActivity2 = this.dfH.dfC;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(mainTabActivity2.getPageContext().getPageActivity())));
        fragmentTabHost = this.dfH.beK;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            fragmentTabHost2 = this.dfH.beK;
            if (fragmentTabHost2.getCurrentTabType() == 3) {
                i = 3;
            } else {
                fragmentTabHost3 = this.dfH.beK;
                if (fragmentTabHost3.getCurrentTabType() != 2) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10378").r("obj_type", i));
    }
}
