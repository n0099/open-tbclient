package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bj dHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar) {
        this.dHR = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("member_close_ad_setting_clicked", true);
        }
        this.dHR.dHA.setVisibility(8);
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10598"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
    }
}
