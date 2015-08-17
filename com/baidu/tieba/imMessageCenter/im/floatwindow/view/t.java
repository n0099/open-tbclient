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
    final /* synthetic */ FloatingPersonalChatActivity bIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bIA = floatingPersonalChatActivity;
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
                str = this.bIA.azh;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.bIA.bIy;
                    str2 = this.bIA.azh;
                    int it = floatingPersonalChatView.it(str2);
                    if (it == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.bIA.getPageContext().getContext();
                        str4 = this.bIA.azh;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (it == 4) {
                        com.baidu.tbadk.newFriends.a Du = com.baidu.tbadk.newFriends.a.Du();
                        str3 = this.bIA.azh;
                        Du.b(com.baidu.adp.lib.g.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
