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
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dpU = floatingPersonalChatActivity;
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
                str = this.dpU.aEL;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.dpU.dpS;
                    str2 = this.dpU.aEL;
                    int mp = floatingPersonalChatView.mp(str2);
                    if (mp == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.dpU.getPageContext().getContext();
                        str4 = this.dpU.aEL;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (mp == 4) {
                        com.baidu.tbadk.newFriends.a FA = com.baidu.tbadk.newFriends.a.FA();
                        str3 = this.dpU.aEL;
                        FA.b(com.baidu.adp.lib.h.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
