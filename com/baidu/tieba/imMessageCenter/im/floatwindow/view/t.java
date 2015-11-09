package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        FloatingPersonalChatView floatingPersonalChatView;
        String str2;
        String str3;
        String str4;
        for (UserData userData : FloatingPersonalChatActivityStatic.getList()) {
            if (userData != null) {
                str = this.bMS.ayp;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.bMS.bMQ;
                    str2 = this.bMS.ayp;
                    int iI = floatingPersonalChatView.iI(str2);
                    if (iI == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.bMS.getPageContext().getContext();
                        str4 = this.bMS.ayp;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (iI == 4) {
                        com.baidu.tbadk.newFriends.a Dh = com.baidu.tbadk.newFriends.a.Dh();
                        str3 = this.bMS.ayp;
                        Dh.b(com.baidu.adp.lib.g.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
