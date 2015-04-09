package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatActivity brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brX = floatingPersonalChatActivity;
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
                str = this.brX.aqC;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.brX.brV;
                    str2 = this.brX.aqC;
                    int hn = floatingPersonalChatView.hn(str2);
                    if (hn == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.brX.getPageContext().getContext();
                        str4 = this.brX.aqC;
                        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (hn == 4) {
                        com.baidu.tbadk.newFriends.a Cg = com.baidu.tbadk.newFriends.a.Cg();
                        str3 = this.brX.aqC;
                        Cg.a(com.baidu.adp.lib.g.c.a(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
