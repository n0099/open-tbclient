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
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity diL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.diL = addFriendActivity;
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
                str = this.diL.userId;
                str2 = this.diL.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new g(str, str2)));
                z = this.diL.diJ;
                if (z) {
                    this.diL.showToast(this.diL.getPageContext().getPageActivity().getString(w.l.group_apply_succ), false);
                } else {
                    this.diL.showToast(this.diL.getPageContext().getPageActivity().getString(w.l.group_apply_succ), false);
                }
                this.diL.finish();
            } else if (AntiHelper.sr(error)) {
                AntiHelper.ap(this.diL.getPageContext().getPageActivity(), errorString);
            } else {
                k.showToast(this.diL.getPageContext().getPageActivity(), errorString);
            }
        }
    }
}
