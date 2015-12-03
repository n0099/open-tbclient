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
    final /* synthetic */ FloatingPersonalChatActivity cbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cbW = floatingPersonalChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        FloatingPersonalChatView floatingPersonalChatView;
        String str2;
        String str3;
        String str4;
        for (UserData userData : FloatingPersonalChatActivityStatic.Qw()) {
            if (userData != null) {
                str = this.cbW.aAu;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.cbW.cbU;
                    str2 = this.cbW.aAu;
                    int jc = floatingPersonalChatView.jc(str2);
                    if (jc == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.cbW.getPageContext().getContext();
                        str4 = this.cbW.aAu;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (jc == 4) {
                        com.baidu.tbadk.newFriends.a Ei = com.baidu.tbadk.newFriends.a.Ei();
                        str3 = this.cbW.aAu;
                        Ei.b(com.baidu.adp.lib.h.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
