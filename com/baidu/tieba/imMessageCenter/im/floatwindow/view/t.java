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
    final /* synthetic */ FloatingPersonalChatActivity bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMx = floatingPersonalChatActivity;
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
                str = this.bMx.azB;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.bMx.bMv;
                    str2 = this.bMx.azB;
                    int iG = floatingPersonalChatView.iG(str2);
                    if (iG == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.bMx.getPageContext().getContext();
                        str4 = this.bMx.azB;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (iG == 4) {
                        com.baidu.tbadk.newFriends.a Dr = com.baidu.tbadk.newFriends.a.Dr();
                        str3 = this.bMx.azB;
                        Dr.b(com.baidu.adp.lib.g.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
