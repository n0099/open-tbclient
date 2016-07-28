package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ab foX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.foX = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        FragmentTabHost fragmentTabHost3;
        int i = 2;
        mainTabActivity = this.foX.foM;
        mainTabActivity2 = this.foX.foM;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(mainTabActivity2.getPageContext().getPageActivity())));
        fragmentTabHost = this.foX.aXH;
        if (fragmentTabHost.getCurrentTabType() != 6) {
            fragmentTabHost2 = this.foX.aXH;
            if (fragmentTabHost2.getCurrentTabType() == 3) {
                i = 3;
            } else {
                fragmentTabHost3 = this.foX.aXH;
                if (fragmentTabHost3.getCurrentTabType() != 2) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        }
        TiebaStatic.log(new ay("c10378").s("obj_type", i));
    }
}
