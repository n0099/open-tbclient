package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ ad flb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ad adVar) {
        this.flb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        int i = 3;
        mainTabActivity = this.flb.fkU;
        mainTabActivity2 = this.flb.fkU;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(mainTabActivity2.getPageContext().getPageActivity())));
        fragmentTabHost = this.flb.bgm;
        if (fragmentTabHost.getCurrentTabType() != 3) {
            fragmentTabHost2 = this.flb.bgm;
            if (fragmentTabHost2.getCurrentTabType() != 2) {
                i = 0;
            } else {
                i = 1;
            }
        }
        TiebaStatic.log(new at("c10378").s("obj_type", i));
    }
}
