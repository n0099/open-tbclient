package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity bsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bsz = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bsz.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.bsz.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? this.bsz.getResources().getString(com.baidu.tieba.y.neterror) : responseCommitInviteMessage.getErrorString());
                return;
            }
            this.bsz.showToast(this.bsz.getPageContext().getString(com.baidu.tieba.y.send_success), false);
            new Handler().postDelayed(new n(this), 400L);
        }
    }
}
