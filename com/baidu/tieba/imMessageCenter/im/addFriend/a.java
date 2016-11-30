package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity dtW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.dtW = addFriendActivity;
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
                str = this.dtW.userId;
                str2 = this.dtW.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new o(str, str2)));
                z = this.dtW.dtV;
                if (z) {
                    this.dtW.showToast(this.dtW.getPageContext().getPageActivity().getString(r.j.add_ok_but_level_is_lower), false);
                } else {
                    this.dtW.showToast(this.dtW.getPageContext().getPageActivity().getString(r.j.group_apply_succ), false);
                }
                this.dtW.finish();
            } else if (AntiHelper.sm(error)) {
                AntiHelper.S(this.dtW.getPageContext().getPageActivity(), errorString);
            } else {
                k.showToast(this.dtW.getPageContext().getPageActivity(), errorString);
            }
        }
    }
}
