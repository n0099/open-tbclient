package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ k dtO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(k kVar) {
        this.dtO = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) this.dtO.getPageContext().getPageActivity(), true, true)));
        }
    }
}
