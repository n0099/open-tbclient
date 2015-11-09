package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity bJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.bJP = addFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        String str;
        String str2;
        boolean z;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
            ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
            int error = responseAddFriendMessage.getError();
            String errorString = responseAddFriendMessage.getErrorString();
            if (error == 0) {
                str = this.bJP.userId;
                str2 = this.bJP.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new i(str, str2)));
                z = this.bJP.bJO;
                if (z) {
                    this.bJP.showToast(this.bJP.getPageContext().getPageActivity().getString(i.h.add_ok_but_level_is_lower), false);
                } else {
                    this.bJP.showToast(this.bJP.getPageContext().getPageActivity().getString(i.h.group_apply_succ), false);
                }
                this.bJP.finish();
            } else if (AntiHelper.lr(error)) {
                AntiHelper.Q(this.bJP.getPageContext().getPageActivity(), errorString);
            } else {
                k.showToast(this.bJP.getPageContext().getPageActivity(), errorString);
            }
        }
    }
}
