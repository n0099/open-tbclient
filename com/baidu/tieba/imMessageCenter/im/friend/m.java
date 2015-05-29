package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity bvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bvA = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bvA.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.bvA.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? this.bvA.getResources().getString(com.baidu.tieba.t.neterror) : responseCommitInviteMessage.getErrorString());
                return;
            }
            this.bvA.showToast(this.bvA.getPageContext().getString(com.baidu.tieba.t.send_success), false);
            new Handler().postDelayed(new n(this), 400L);
        }
    }
}
