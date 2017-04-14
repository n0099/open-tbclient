package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ l dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.dkD = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean isLogin;
        isLogin = this.dkD.isLogin();
        if (isLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) this.dkD.getPageContext().getPageActivity(), true, true)));
        }
    }
}
