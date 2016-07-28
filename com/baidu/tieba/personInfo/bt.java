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
public class bt implements View.OnClickListener {
    final /* synthetic */ bq eCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.eCH = bqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10601"));
        this.eCH.eCr.setImageDrawable(null);
        this.eCH.eCr.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sN().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.eCH.bgI;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(baseFragmentActivity.getPageContext().getPageActivity())));
    }
}
