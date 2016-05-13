package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bj dHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar) {
        this.dHR = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10601"));
        this.dHR.dHB.setImageDrawable(null);
        this.dHR.dHB.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sR().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.dHR.cSp;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(baseFragmentActivity.getPageContext().getPageActivity())));
    }
}
