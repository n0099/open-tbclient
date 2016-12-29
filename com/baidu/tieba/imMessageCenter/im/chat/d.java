package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.cZd = personalChatActivity;
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
        absMsglistView = this.cZd.cGz;
        userData = this.cZd.mUser;
        String userName = userData.getUserName();
        bVar = this.cZd.cYU;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.cZd.cYT;
        if (j != 0) {
            handler = this.cZd.mHandler;
            runnable = this.cZd.cYY;
            j2 = this.cZd.cYT;
            handler.postDelayed(runnable, j2);
        }
    }
}
