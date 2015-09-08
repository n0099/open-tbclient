package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bGq = personalChatActivity;
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
        absMsglistView = this.bGq.mListView;
        userData = this.bGq.mUser;
        String userName = userData.getUserName();
        bVar = this.bGq.bGh;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bGq.bGg;
        if (j != 0) {
            handler = this.bGq.mHandler;
            runnable = this.bGq.bGl;
            j2 = this.bGq.bGg;
            handler.postDelayed(runnable, j2);
        }
    }
}
