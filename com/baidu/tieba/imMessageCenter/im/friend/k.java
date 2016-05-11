package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity cwP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.cwP = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.cwP.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.cwP.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? this.cwP.getResources().getString(t.j.neterror) : responseCommitInviteMessage.getErrorString());
                return;
            }
            this.cwP.showToast(this.cwP.getPageContext().getString(t.j.send_success), false);
            new Handler().postDelayed(new l(this), 400L);
        }
    }
}
