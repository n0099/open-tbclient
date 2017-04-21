package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p dlA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.dlA = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteFriendListActivity inviteFriendListActivity;
        inviteFriendListActivity = this.dlA.dln;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(inviteFriendListActivity.getPageContext().getPageActivity())));
    }
}
