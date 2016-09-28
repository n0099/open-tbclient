package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity doA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.doA = personalChatActivity;
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
        absMsglistView = this.doA.cVE;
        userData = this.doA.mUser;
        String userName = userData.getUserName();
        bVar = this.doA.dor;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.doA.doq;
        if (j != 0) {
            handler = this.doA.mHandler;
            runnable = this.doA.dov;
            j2 = this.doA.doq;
            handler.postDelayed(runnable, j2);
        }
    }
}
