package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dui = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        absMsglistView = this.dui.dbp;
        userData = this.dui.mUser;
        String userName = userData.getUserName();
        bVar = this.dui.dtZ;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.dui.dtY;
        if (j != 0) {
            handler = this.dui.mHandler;
            runnable = this.dui.dud;
            j2 = this.dui.dtY;
            handler.postDelayed(runnable, j2);
        }
    }
}
