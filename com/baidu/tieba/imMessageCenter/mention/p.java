package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.duq = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean isLogin;
        isLogin = this.duq.isLogin();
        if (isLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) this.duq.getPageContext().getPageActivity(), true, true)));
        }
    }
}
