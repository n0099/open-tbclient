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
    final /* synthetic */ FloatingPersonalChatActivity cvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cvc = floatingPersonalChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        FloatingPersonalChatView floatingPersonalChatView;
        String str2;
        String str3;
        String str4;
        for (UserData userData : FloatingPersonalChatActivityStatic.UL()) {
            if (userData != null) {
                str = this.cvc.aDP;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.cvc.cva;
                    str2 = this.cvc.aDP;
                    int kd = floatingPersonalChatView.kd(str2);
                    if (kd == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.cvc.getPageContext().getContext();
                        str4 = this.cvc.aDP;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (kd == 4) {
                        com.baidu.tbadk.newFriends.a Gf = com.baidu.tbadk.newFriends.a.Gf();
                        str3 = this.cvc.aDP;
                        Gf.b(com.baidu.adp.lib.h.b.c(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
