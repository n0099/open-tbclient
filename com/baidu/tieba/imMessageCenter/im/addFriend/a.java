package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity cht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.cht = addFriendActivity;
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
                str = this.cht.userId;
                str2 = this.cht.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new k(str, str2)));
                z = this.cht.chs;
                if (z) {
                    this.cht.showToast(this.cht.getPageContext().getPageActivity().getString(t.j.add_ok_but_level_is_lower), false);
                } else {
                    this.cht.showToast(this.cht.getPageContext().getPageActivity().getString(t.j.group_apply_succ), false);
                }
                this.cht.finish();
            } else if (AntiHelper.or(error)) {
                AntiHelper.X(this.cht.getPageContext().getPageActivity(), errorString);
            } else {
                com.baidu.adp.lib.util.k.showToast(this.cht.getPageContext().getPageActivity(), errorString);
            }
        }
    }
}
