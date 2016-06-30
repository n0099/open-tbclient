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
public class bu implements View.OnClickListener {
    final /* synthetic */ bs eqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bs bsVar) {
        this.eqW = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10601"));
        this.eqW.eqG.setImageDrawable(null);
        this.eqW.eqG.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sO().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.eqW.bfw;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(baseFragmentActivity.getPageContext().getPageActivity())));
    }
}
