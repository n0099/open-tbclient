package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bJv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bJv = personalChatActivity;
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
        absMsglistView = this.bJv.mListView;
        userData = this.bJv.mUser;
        String userName = userData.getUserName();
        bVar = this.bJv.bJm;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bJv.bJl;
        if (j != 0) {
            handler = this.bJv.mHandler;
            runnable = this.bJv.bJq;
            j2 = this.bJv.bJl;
            handler.postDelayed(runnable, j2);
        }
    }
}
