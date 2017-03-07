package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.diy = addFriendActivity;
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
                str = this.diy.userId;
                str2 = this.diy.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new g(str, str2)));
                z = this.diy.diw;
                if (z) {
                    this.diy.showToast(this.diy.getPageContext().getPageActivity().getString(w.l.group_apply_succ), false);
                } else {
                    this.diy.showToast(this.diy.getPageContext().getPageActivity().getString(w.l.group_apply_succ), false);
                }
                this.diy.finish();
            } else if (AntiHelper.rZ(error)) {
                AntiHelper.an(this.diy.getPageContext().getPageActivity(), errorString);
            } else {
                k.showToast(this.diy.getPageContext().getPageActivity(), errorString);
            }
        }
    }
}
