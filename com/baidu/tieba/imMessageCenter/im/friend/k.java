package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity ccO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.ccO = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.ccO.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.ccO.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? this.ccO.getResources().getString(n.i.neterror) : responseCommitInviteMessage.getErrorString());
                return;
            }
            this.ccO.showToast(this.ccO.getPageContext().getString(n.i.send_success), false);
            new Handler().postDelayed(new l(this), 400L);
        }
    }
}
