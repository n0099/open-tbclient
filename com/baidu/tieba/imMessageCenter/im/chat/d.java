package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dnc = personalChatActivity;
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
        absMsglistView = this.dnc.cUk;
        userData = this.dnc.mUser;
        String userName = userData.getUserName();
        bVar = this.dnc.dmT;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.dnc.dmS;
        if (j != 0) {
            handler = this.dnc.mHandler;
            runnable = this.dnc.dmX;
            j2 = this.dnc.dmS;
            handler.postDelayed(runnable, j2);
        }
    }
}
