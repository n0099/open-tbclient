package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bKb = personalChatActivity;
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
        absMsglistView = this.bKb.mListView;
        userData = this.bKb.mUser;
        String userName = userData.getUserName();
        bVar = this.bKb.bJS;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bKb.bJR;
        if (j != 0) {
            handler = this.bKb.mHandler;
            runnable = this.bKb.bJW;
            j2 = this.bKb.bJR;
            handler.postDelayed(runnable, j2);
        }
    }
}
