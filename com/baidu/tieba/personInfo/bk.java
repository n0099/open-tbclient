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
public class bk implements View.OnClickListener {
    final /* synthetic */ bi dEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar) {
        this.dEC = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10601"));
        this.dEC.dEm.setImageDrawable(null);
        this.dEC.dEm.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.dEC.duj;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(baseFragmentActivity.getPageContext().getPageActivity())));
    }
}
